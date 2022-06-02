
Feature: Добавление новой записи в дневник

  Background:
    Given User authorized

  @hooks
    @close
  Scenario Outline:
    When Click To New Entry button
    And Create Header '<header>'
    And Create Message '<textMessage>'
    And Leave a smile
    And publish an entry
    Then check content and header
    Examples:
      | header   | textMessage     |
      | Autotest | Hello, it is me |







