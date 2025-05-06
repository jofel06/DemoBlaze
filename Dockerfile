#Build and Test
FROM maven:3.9.6-eclipse-temurin-21

# Set working directory
WORKDIR /app

# install chrome browser
RUN apt-get update && apt-get install -y wget unzip && \
    wget https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb && \
    apt install -y ./google-chrome-stable_current_amd64.deb && \
    rm google-chrome-stable_current_amd64.deb && \
    apt-get clean

# Copy the project files into the container
COPY . .

# Compile
RUN mvn clean compile
#RUN mkdir -p /app/tmp

# Now define the test command to run **when the container is executed**
CMD ["mvn", "test", "-Dsurefire.suiteXmlFiles=src/test/resources/testng_suites/chrome_specific_suites/chrome_login_tests.xml"]

