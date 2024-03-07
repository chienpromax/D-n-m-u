-------------------------------------------------------------------------
exe4j readme

version 9.0
released on 2023-01-17
-------------------------------------------------------------------------

I. LICENSE

The license agreement (EULA) can be found in license.txt in the same
directory as this readme file.


II. RUNNING exe4j

1. WINDOWS

Start exe4j by executing

   [exe4j install directory]\bin\exe4j.exe
   
   
2. LINUX/UNIX

Start exe4j by executing the shell script

   [exe4j install directory]/bin/exe4j


3. macOS

Start exe4j with the application bundle

    [exe4j install directory]/bin/exe4j


III. Upgrading exe4j

You may install a new version of exe4j on top of an older version.
Your old configuration files are upwards compatible.


IV. DOCUMENTATION

Help is available 

1. from the "Help" button in the exe4j wizard
2. as PDF in the doc directory of your exe4j installation.
3. online at https://www.ej-technologies.com/resources/exe4j/help/doc/
4. by executing exe4jc.exe --help


V. DIRECTORY LAYOUT

An installation of exe4j contains the following directories:

   bin
         contains the executables for exe4j.
   
   config
         contains all configuration files for exe4j
   
   demo
         contains demo configuration files and applications
         to try out exe4j
         
   doc
         contains the documentation for exe4j
   
   lib
         contains external libraries used by exe4j. If the libraries
         come with an different license, it is reproduced in that
         directory.
         
   resource
         contains resources for the exe4j compiler