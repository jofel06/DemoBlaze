#Build and Test
FROM maven:3.9.6-eclipse-temurin-21

# Set working directory
WORKDIR /app

# Install Google Chrome (headless mode)
RUN apt-get update && \
    apt-get install -y wget gnupg curl && \
    curl -fsSL https://dl.google.com/linux/linux_signing_key.pub | gpg --dearmor -o /usr/share/keyrings/google-chrome.gpg && \
    echo "deb [arch=amd64 signed-by=/usr/share/keyrings/google-chrome.gpg] http://dl.google.com/linux/chrome/deb/ stable main" > /etc/apt/sources.list.d/google-chrome.list && \
    apt-get update && \
    apt-get install -y google-chrome-stable && \
    rm -rf /var/lib/apt/lists/*

# Set the Chrome binary location (used by Selenium WebDriver)
ENV CHROME_BIN=/usr/bin/google-chrome

# Copy the project files into the container
COPY . .

# Compile
RUN mvn clean compile

# Now define the test command to run **when the container is executed**
CMD ["mvn", "test", "-Dsurefire.suiteXmlFiles=src/test/resources/testng_suites/chrome_specific_suites/chrome_login_tests.xml"]
