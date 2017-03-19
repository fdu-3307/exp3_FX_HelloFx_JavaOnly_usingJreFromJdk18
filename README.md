# exp3_FX_HelloFx_JavaOnly_usingJreFromJdk18
Example Java project created via STS as Java Project, showing how to;
- do JavaFX with only Java, including the UI
- write JavaFX application via using JRE from jdk1.8,
- put a Label into a Scene into a Stage (FX1_HelloWorld), 
- use layouts (StackPane, HBox, VBox)
- have nested layouts (above 3 layouts in FlowPane)
- basic characteristics of layouts StackPane, HBox, VBox, FlowPane
- handle events using "anonymous inner class that implements EventHandler interface"
- handle events using "java 8 lambda expressions"
- put Buttons with an action handler into a layouts, into Scene, into Stage (FX2_Layouts)
- a calculator implemented in pure Java way of JavaFX (FX3_Calculator)
- implementing ActionEvent and KeyEvent (on key release) (FX3_Calculator.handleActionEvent, FX3_Calculator.handleKeyEvent)
- using CSS to set styles in JavaFX (FX4_HelloCSS)
- run JavaFX as "Java Application" like any other Java Project

## Setup dependencies
Make sure on your machine, you have;
- STS installed
- git installed
- a working unix shell (like git bash. If not there install git and use its "git bash")
- working JDK 1.8 installed (with JAVA_HOME env variable added, and PATH env variable prefixed with %JAVA_HOME%/bin)
- make sure JRE System Library is from jdk1.8 (delete it and recrete the JRE System Library if it is not from jdk)

## How to use it  (NOTE in below the directory structure and names are suggested)
### Make sure you created the directory structure you want to store example projects in
As example, at bash command line issue;<br>
mkdir -p /c/fdu/csci3307/projects

### to import the project from github to STS
In github, go to the repository you want to clone<br>
https://github.com/fdu-3307/exp3_FX_HelloFx_JavaOnly_usingJreFromJdk18.git <br>
click green "Clone or download" on right hand side<br>
click icon with "Copy to clipboard" tooltip (NOTE when you click that later during import in STS most fields of "Source Git Repository" will be auto populated) or copy the URL

In STS
File --> Import --> Git --> Projects from Git + Next --> Clone URI + Next --> URI, Host, Repository path, Protocol of "Source Git Repsitory" will be auto filled, fill in Authentication section, click check box of "Store in Secure Store" + Next --> let "master" be selected in "Branch Selection" + Next --> in "Local Destination" type in Directory or click Browse and select workspace, let "origin" be Remote name + Next  --> in "Select a wizard to use for importing projects" click radio button of "Import using the New Project wizard" + Finish<br>
in "Select a wizard" click Java --> Java Project + Next --> in "Create a Java Project" enter "Project name" value + Finish

Now you should see the project in STS with yellow milk tank on its lower right corner and blue J in its upper right corner  

### or to clone the project from github via command line to a directory
cd to where you put your example projects.<br>
As example, at bash command line issue;<br>
cd /c/fdu/csci3307/projects <br>
git clone https://github.com/fdu-3307/exp3_FX_HelloFx_JavaOnly_usingJreFromJdk18.git <br>
or<br>
git clone https://github.com/fdu-3307/exp3_FX_HelloFx_JavaOnly_usingJreFromJdk18.git  whateverDirectoryNameYouWantStuffToBeClonedInto

Now you can import the project into STS via
File --> Import --> General --> Existing Projects into Workspace , then follow the wizard

### to run the project from STS
- Right click on project, Run As --> Java Application, click FX1_HelloWorld or FX2_Layouts or FX3_Calculator  or FX4_HelloCSS from list
or
- Right click on FX1_HelloWorld, Run As --> Java Application
- Right click on FX2_Layouts, Run As --> Java Application
- Right click on FX3_Calculator, Run As --> Java Application
- Right click on FX4_HelloCSS, Run As --> Java Application

## Project directory structure
- README.md this read me file
- src directory of java packages
- src/com.mycompany.exp3.one containing FX1_HelloWorld
- src/com.mycompany.exp3.two containing FX2_Layouts
- design directory of design documents, like class diagram
