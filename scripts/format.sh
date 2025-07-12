#!/bin/bash

# Colors
GREEN='\033[0;32m'
RED='\033[0;31m'
YELLOW='\033[0;33m'
NC='\033[0m' # No Color

# Path to the .astylerc file (one directory above this script's folder)
ASTYLERCRC="$(dirname "$(dirname "$0")")/.astylerc"
KTFMT_JAR="$(dirname "$(dirname "$0")")/ktfmt.jar"

echo -e "\n${GREEN}Looking for Java files to format using astyle...${YELLOW}\n"

# Find all .kt and .java files in the project to format with astyle
find "$(dirname "$0")/../src" -type f \( -name "*.java" \) \
-exec astyle --project="$ASTYLERCRC" {} -n \;

echo -e "\n${GREEN}Looking for Kotlin files to format using ktfmt...${YELLOW}\n"

# Find all .kt files in the project to format with ktfmt
find "$(dirname "$0")/../src" -type f \( -name "*.kt" \) \
-exec java -jar $KTFMT_JAR --kotlinlang-style {} \;

# Check if astyle was successful
if [ $? -eq 0 ]; then
    echo -e "\n${GREEN}All files formatted successfully.${NC}"
else
    echo -e "\n${RED}There were errors during formatting.${NC}"
    exit 1
fi