*** Settings ***
Resource           ../keywords/students.resource

Suite Setup         Run Keywords   Create Iotw Session
Suite Teardown      Delete All Sessions

Test Tags           Smoke   API

*** Test Cases ***
