*** Settings ***
Library  Selenium2Library

Suite Teardown  Close All Browsers

*** Variables ***
@{chrome_options}  --help
${chrome_binary}  /Applications/Google\ Chrome.app/Contents/MacOS/Google\ Chrome

*** Test Cases ***
Hello chrome headless
    ${options}=  Set Chrome Options
    ${options.set_binary}=  Set Variable  set_binary=${chrome_binary}
    Create WebDriver  Chrome  chrome_options=${options}
 
    Go To    https://medium.com/@nottyo
    Wait Until Page Contains    Automation Engineer

*** Keywords ***
Set Chrome Options
    [Documentation]    Set Chrome options for headless mode
    ${options}=    Evaluate    sys.modules['selenium.webdriver'].ChromeOptions()    sys, selenium.webdriver
    : FOR    ${option}    IN    @{chrome_options}
    \    Call Method    ${options}    add_argument    ${option}
    [Return]    ${options}
