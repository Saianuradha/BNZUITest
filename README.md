# BNZUITest

## Description
This project is an UI Automation testing project developed with Selenium, BDD-Cucumber framework. I used TestNG as Assertion tool, Maven for build purpose.
This project is integrated with Github Actions CI pipeline

## Steps to run tests in Windows/Mac.
1. Import code from git repository url from eclipse/other IDE.
2. If you find any Build errors, then right click on `Project Root Folder->Maven->Update Project`
3. If you get chrome driver error, then you need to update your chrome to the latest version, today (01-09-2022) latest version is 105.xx., Open chrome->goto settings->about chrome->update chrome version to latest(105) and click on Relaunch button after installing latest chrome version.

## Troubleshoot in Mac OS.
1. Download chrome driver from this location(https://chromedriver.storage.googleapis.com/105.0.5195.52/chromedriver_mac64.zip) and unzip the downloaded folder. Now open terminal and go to downloaded folder and type below commands. 
`mv chrome driver /usr/local/bin`
2. If we get chrome driver cannot be verified error then enter below command in terminal. `xattr -d com.apple.quarantine /usr/local/bin/chromedriver`

## Reference links:
1. For Setting chrome driver path in Mac OS. https://www.swtestacademy.com/install-chrome-driver-on-mac/
