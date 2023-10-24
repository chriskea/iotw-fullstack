*** Settings ***
Resource   ../variables/students.resource
Library    RequestsLibrary

*** Keywords ***
Create Iotw Session
    Create Session  mysession  ${BASE_URL}  verify=true

GET Students
    [Arguments]    ${expected_status}=any
     ${response}=    GET On Session
     ...    mysession
     ...    ${IOTW_ENDPOINTS_STUDENTS}
     ...    expected_status=${expected_status}
