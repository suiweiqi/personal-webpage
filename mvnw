#!/bin/sh
# Maven Wrapper startup script for Unix/Linux/macOS
# ----------------------------------------------------------------------------

MAVEN_PROJECTBASEDIR="$(cd "$(dirname "$0")" && pwd)"
export MAVEN_OPTS="-Xmx1024m"

if [ -z "$MAVEN_HOME" ]; then
    MAVEN_HOME="$HOME/.m2/wrapper/dists/apache-maven-3.9.6"
fi

if [ ! -f "$MAVEN_HOME/bin/mvn" ]; then
    echo "Downloading Maven..."
    mkdir -p "$(dirname "$MAVEN_HOME")"
    if [ ! -f "$MAVEN_PROJECTBASEDIR/.mvn/wrapper/maven-wrapper.jar" ]; then
        if command -v curl >/dev/null 2>&1; then
            curl -fsSL -o "$MAVEN_PROJECTBASEDIR/.mvn/wrapper/maven-wrapper.jar" \
                "https://repo.maven.apache.org/maven2/org/apache/maven/wrapper/maven-wrapper/3.2.0/maven-wrapper-3.2.0.jar"
        elif command -v wget >/dev/null 2>&1; then
            wget -q -O "$MAVEN_PROJECTBASEDIR/.mvn/wrapper/maven-wrapper.jar" \
                "https://repo.maven.apache.org/maven2/org/apache/maven/wrapper/maven-wrapper/3.2.0/maven-wrapper-3.2.0.jar"
        fi
    fi
    java -jar "$MAVEN_PROJECTBASEDIR/.mvn/wrapper/maven-wrapper.jar" \
        -d "$MAVEN_HOME" \
        -u "https://repo.maven.apache.org/maven2/org/apache/maven/apache-maven/3.9.6/apache-maven-3.9.6-bin.zip"
fi

exec "$MAVEN_HOME/bin/mvn" "$@"
