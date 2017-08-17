*** Settings ***
Library  Selenium2Library

Suite Teardown  Close All Browsers

*** Variables ***
@{chrome_options}  --help
${chrome_binary}  /Applications/Google\ Chrome.app/Contents/MacOS/Google\ Chrome
${campaign_name}    aaaa
${blank_campaign_name}   

*** Keywords ***
Set Chrome Options
    [Documentation]    Set Chrome options for headless mode
    ${options}=    Evaluate    sys.modules['selenium.webdriver'].ChromeOptions()    sys, selenium.webdriver
    : FOR    ${option}    IN    @{chrome_options}
    \    Call Method    ${options}    add_argument    ${option}
    [Return]    ${options}
Should be Open Browser
    ${options}=  Set Chrome Options
    ${options.set_binary}=  Set Variable  set_binary=${chrome_binary}
    Create WebDriver  Chrome  chrome_options=${options}
    Go To    http://localhost:9000/create_campaign.html
Create Correct Campaign
    Input Text      id=txtCampaignName  ${campaign_name}
    Click Element   id=btnCreateCampaign
Input Blank Campaign Name
    Input Text      id=txtCampaignName  ${blank_campaign_name}
    Click Element   id=btnCreateCampaign

*** Test Cases ***
Test Create Correct Campaign
    Should be Open Browser
    Create Correct Campaign

Test Blank Campain Name
    Should be Open Browser
    Input Blank Campaign Name
