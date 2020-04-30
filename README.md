## Calculate the Great Circle Distance By Haversine

#### The app has following packages:

 1. **dto**: Models to hold the data.
 2. **exception**: Custom exception.
 3. **main**: Main classes.
 4. **util**: Utility classes.
 5. **test**: Include test classes and test cases.
 
 ### Installation and run by IDE
 
 1. IntelliJ IDEA 2019.2.2 from [here](https://www.jetbrains.com/idea/download/)
 2. Run `main.AppKt` from top right corner
 
 ### Installation and run by command
  
  1. IntelliJ IDEA 2019.2.2 from [here](https://www.jetbrains.com/idea/download/)
  2. Rebuild the project
  3. Run `shadowJar` from gradle task from right pane
  4. Go to `libs` folder, under `build` folder from left pane
  5. Copy built jar to the desktop
  6. Copy `customers.json` from root of project to the same place as previous step
  7. If you have not installed kotlin yet, run this command on your terminal: `brew update` & `brew install kotlin`
  8. Run this command to run the Jar: `kotlin -cp Intercom-1.0.0-all.jar main.AppKt`
 
 ### Run test cases
 
 1. Go to test folder and run each appropriate test cases.
 
 ![Screenshot](https://raw.githubusercontent.com/Drjacky/Intercom/master/output.png)
 
 ### License
 ```
    MIT License
    
    Copyright (c) 2018 Dr.jacky
    
    Permission is hereby granted, free of charge, to any person obtaining a copy
    of this software and associated documentation files (the "Software"), to deal
    in the Software without restriction, including without limitation the rights
    to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
    copies of the Software, and to permit persons to whom the Software is
    furnished to do so, subject to the following conditions:
    
    The above copyright notice and this permission notice shall be included in all
    copies or substantial portions of the Software.
    
    THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
    IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
    FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
    AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
    LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
    OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
    SOFTWARE.
 ```
 
