document.addEventListener("DOMContentLoaded", function () {
    const generateButton = document.getElementById("generate-button");
    const generatedPasswordElement = document.getElementById("generated-password");

    generateButton.addEventListener("click", function () {
        // Implement your Java code logic here in JavaScript
        // Call the Java code's functionality to generate passwords
        const generatedPassword = generatePassword(12);

        // Display the generated password on the webpage
        generatedPasswordElement.textContent = "Generated Password: " + generatedPassword;
    });
});
