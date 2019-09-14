## EventFilter

Response to programming challenge posted [here](https://github.com/kyleboyle/eventfilter)

## How To Run:
The executable will use the reports.json, reports.csv, and reports.xml files in the same directory as the executable JAR if no other arguments are provided. Find an already-built JAR in /executable folder with the thee input files. The following command will create the output.csv file in the /executable directory.

    C:\Users\Joel\git\eventfilter\executable>java -jar eventfilter-0.0.1-SNAPSHOT-shaded.jar
    
You may also provide the path to another folder as an argument. This folder must contain all three of the input files. The output files will be placed in the provided folder as well.

    java -jar eventfilter-0.0.1-SNAPSHOT-shaded.jar "C:/Users/Joel/Desktop/files/"
