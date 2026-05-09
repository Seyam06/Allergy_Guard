/**
 * Allergy Guard - Dashboard Logic
 * Feature: Navigation System & Symptom Tracking
 */

// --- 1. INITIALIZATION ---
document.addEventListener('DOMContentLoaded', () => {
    displayCurrentDate();


    loadMedicalHistory();
    // loadMedicineSuggestions();

    console.log("Allergy Guard Dashboard Initialized.");
});
// --- 2. DATE DISPLAY ---
function displayCurrentDate() {
    const dateElement = document.getElementById('current-date');
    if (dateElement) {
        dateElement.innerText = new Date().toLocaleDateString('en-US', {
            weekday: 'long',
            year: 'numeric',
            month: 'long',
            day: 'numeric'
        });
    }
}

// --- 3. NAVIGATION SYSTEM ---
/**
 * Toggles between different sections of the dashboard
 * @param {string} sectionId - The ID of the section to show
 * @param {HTMLElement} navElement - The clicked navigation link
 */
function showSection(sectionId, navElement) {
    // Hide all sections by removing 'active' class
    document.querySelectorAll('.content-section').forEach(section => {
        section.classList.remove('active');
    });

    // Remove 'active' class from all nav items
    document.querySelectorAll('.nav-item').forEach(item => {
        item.classList.remove('active');
    });

    // Show the target section
    const targetSection = document.getElementById(sectionId);
    if (targetSection) {
        targetSection.classList.add('active');
    }

    // Highlight the active nav item
    if (navElement) {
        navElement.classList.add('active');
    }
}

// --- 4. SYMPTOM TRACKER LOGIC ---
/**
 * Processes selected symptoms and provides feedback
 */
function processSymptoms() {
    const checkboxes = document.querySelectorAll('input[name="symptoms"]:checked');
    const selectedSymptoms = Array.from(checkboxes).map(cb => cb.value);

    if (selectedSymptoms.length === 0) {
        alert("Please select at least one symptom.");
        return;
    }

    fetch('/api/symptoms/save', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ symptoms: selectedSymptoms })
    })
        .then(response => {
            if (response.ok) {
                alert("Symptoms saved successfully!");
                location.reload();
            } else {
                alert("Error saving symptoms.");
            }
        });
}

// --- 5. PLACEHOLDER FOR ENVIRONMENTAL DATA ---
function updateDashboardMetrics(pollen, aqi, humidity) {
    console.log("Fetching environmental data from API...");
    // Future Logic: Update DOM elements with real-time weather data
}





document.addEventListener('DOMContentLoaded', function() {
    loadWeatherData();
});

function loadWeatherData() {
    fetch('/api/weather/current')
        .then(response => {
            if (!response.ok) throw new Error('Network response was not ok');
            return response.json();
        })
        .then(data => {
            if (data) {
                document.getElementById('temp-val').innerText = data.temperature + "°C";
                document.getElementById('hum-val').innerText = data.humidity + "%";
                document.getElementById('pollen-val').innerText = data.pollen_level;

                const aqiElement = document.getElementById('aqi-val');
                aqiElement.innerText = data.airQuality + " AQI";

                if(data.airQuality > 150) {
                    aqiElement.style.color = "#f43f5e";
                    aqiElement.style.fontWeight = "bold";
                } else {
                    aqiElement.style.color = "inherit";
                }
            }
        })
        .catch(error => {
            console.error('Error fetching weather:', error);
            document.getElementById('aqi-val').innerText = "N/A";
        });
}



function loadMedicineSuggestions() {
    fetch('/api/medicines/suggestions')
        .then(response => response.json())
        .then(medicines => {
            const list = document.getElementById('medicine-list');
            list.innerHTML = '';

            medicines.forEach(med => {
                list.innerHTML += `
                    <div class="care-card med-card-style">
                        <div class="card-accent med-accent"></div>
                        <div class="icon-box med-bg">💊</div>
                        <div class="card-info">
                            <span class="category-pill med-pill">${med.category}</span>
                            <h3>${med.medicineName}</h3>
                            <p class="dosage-info"><strong>Dosage:</strong> ${med.dosage}</p>
                        </div>
                    </div>
                `;
            });
        })
        .catch(err => console.error("Medicine load error:", err));
}

// পেজ লোড হওয়ার সময় কল করুন
document.addEventListener('DOMContentLoaded', loadMedicineSuggestions);



function loadMedicalHistory() {
    const container = document.getElementById('history-timeline');

    if (!container) return;

    fetch('/api/history/timeline')
        .then(response => response.json())
        .then(data => {
            if (!data || data.length === 0) return;

            let dynamicHtml = '';
            data.forEach(item => {
                const symptomsText = item.symptoms.join(' & ');
                const riskClass = item.riskLevel.toLowerCase();

                dynamicHtml += `
                    <div class="timeline-item dynamic-record">
                        <div class="timeline-marker ${riskClass}-risk"></div>
                        <div class="timeline-content">
                            <div class="log-date">${item.date}</div>
                            <div class="log-card">
                                <div class="log-header">
                                    <h3>${symptomsText}</h3>
                                    <span class="risk-badge ${riskClass}">${item.riskLevel} Risk</span>
                                </div>
                                <p class="log-details">Environment: ${item.weatherSummary}</p>
                                <div class="log-footer">
                                    <span>💊${item.medicineSuggestion}</span>
                                </div>
                            </div>
                        </div>
                    </div>
                `;
            });

            container.insertAdjacentHTML('afterbegin', dynamicHtml);
        })
        .catch(err => console.error("History fetch error:", err));
}