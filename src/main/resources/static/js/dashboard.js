/**
 * Allergy Guard - Dashboard Logic
 * Feature: Navigation System & Symptom Tracking
 */

// --- 1. INITIALIZATION ---
document.addEventListener('DOMContentLoaded', () => {
    displayCurrentDate();
    // Default entry log
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
    // Collect all checked checkbox values
    const checkboxes = document.querySelectorAll('input[name="symptoms"]:checked');
    const selectedSymptoms = Array.from(checkboxes).map(cb => cb.value);

    // Validation
    if (selectedSymptoms.length === 0) {
        alert("Please select at least one symptom to analyze your risk.");
        return;
    }

    // Professional UI Feedback
    console.log("Symptoms Recorded:", selectedSymptoms);
    alert("Symptoms saved successfully! Your risk profile is being updated.");

    // Logic for Future Backend Integration (Spring Boot):
    // In next steps, we will use fetch() to send 'selectedSymptoms' to your Controller.

    // Return to main dashboard to see updated risk
    const dashboardNavLink = document.querySelector('.nav-menu .nav-item');
    showSection('dashboard', dashboardNavLink);
}

// --- 5. PLACEHOLDER FOR ENVIRONMENTAL DATA ---
function updateDashboardMetrics(pollen, aqi, humidity) {
    console.log("Fetching environmental data from API...");
    // Future Logic: Update DOM elements with real-time weather data
}
