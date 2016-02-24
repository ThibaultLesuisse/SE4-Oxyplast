$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("BE/Odisee/Oxyplast/Oxyplast_PorjectToevoegen.feature");
formatter.feature({
  "id": "een-project-toevoegen",
  "description": "\r\nGegeven: Een accountverantwoordelijke moet eerst een klant toevoegen als er nog geen bestaat.\r\nDan wordt een aanvraag ingediend die dan moeten worden goedgekeurd en pas daarna kan een project worden \r\ngestart.",
  "name": "Een project toevoegen",
  "keyword": "Functionaliteit",
  "line": 3,
  "comments": [
    {
      "value": "# language: nl",
      "line": 1
    }
  ]
});
formatter.background({
  "description": "",
  "name": "Indien de klant nog niet bestaat en die wil worden opgenomen in ons klantenbestand",
  "keyword": "Achtergrond",
  "line": 9,
  "type": "background"
});
formatter.scenario({
  "id": "een-project-toevoegen;de-accountverantwoordelijke-voegt-een-klant-toe",
  "description": "",
  "name": "De accountverantwoordelijke voegt een klant toe",
  "keyword": "Scenario",
  "line": 11,
  "type": "scenario"
});
formatter.step({
  "name": "de klant wordt toegevoegd",
  "keyword": "Als ",
  "line": 12
});
formatter.step({
  "name": "is de lijst van klanten 1 groot.",
  "keyword": "Dan ",
  "line": 13
});
formatter.step({
  "name": "zou de klant \"Dubai\" in de lijst moeten voorkomen",
  "keyword": "En ",
  "line": 14
});
formatter.match({
  "location": "StepDefinitions.de_klant_wordt_toegevoegd()"
});
formatter.result({
  "duration": 186597000,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "1",
      "offset": 24
    }
  ],
  "location": "StepDefinitions.is_de_lijst_van_klanten_groot(int)"
});
formatter.result({
  "duration": 1914000,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Dubai",
      "offset": 14
    }
  ],
  "location": "StepDefinitions.zou_de_klant_in_de_lijst_moeten_voorkomen(String)"
});
formatter.result({
  "duration": 616000,
  "status": "passed"
});
formatter.background({
  "description": "",
  "name": "Indien de klant nog niet bestaat en die wil worden opgenomen in ons klantenbestand",
  "keyword": "Achtergrond",
  "line": 9,
  "type": "background"
});
formatter.scenario({
  "id": "een-project-toevoegen;de-klant-dient-een-aanvraag-in",
  "description": "",
  "name": "De Klant dient een aanvraag in",
  "keyword": "Scenario",
  "line": 16,
  "type": "scenario"
});
formatter.step({
  "name": "de aanvraag wordt aangemaakt",
  "keyword": "Als ",
  "line": 17
});
formatter.step({
  "name": "moet de Boolean aanvaard op true staan",
  "keyword": "Dan ",
  "line": 18
});
formatter.match({
  "location": "StepDefinitions.de_aanvraag_wordt_aangemaakt()"
});
formatter.result({
  "duration": 50000,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitions.moet_de_Boolean_aanvaard_op_true_staan()"
});
formatter.result({
  "duration": 46000,
  "status": "passed"
});
formatter.background({
  "description": "",
  "name": "Indien de klant nog niet bestaat en die wil worden opgenomen in ons klantenbestand",
  "keyword": "Achtergrond",
  "line": 9,
  "type": "background"
});
formatter.scenario({
  "id": "een-project-toevoegen;de-accountverantwoordelijke-start-het-project-op",
  "description": "",
  "name": "De accountverantwoordelijke start het project op",
  "keyword": "Scenario",
  "line": 20,
  "type": "scenario"
});
formatter.step({
  "name": "het project wordt toegevoegd",
  "keyword": "Als ",
  "line": 21
});
formatter.step({
  "name": "is de lijst van projecten 1 groot",
  "keyword": "Dan ",
  "line": 22
});
formatter.step({
  "name": "zou het project \"DubaiVerf\" van de klant in de lijst moeten voorkomen",
  "keyword": "En ",
  "line": 23
});
formatter.match({
  "location": "StepDefinitions.het_project_wordt_toegevoegd()"
});
formatter.result({
  "duration": 46000,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "1",
      "offset": 26
    }
  ],
  "location": "StepDefinitions.is_de_lijst_van_projecten_groot(int)"
});
formatter.result({
  "duration": 79000,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "DubaiVerf",
      "offset": 17
    }
  ],
  "location": "StepDefinitions.zou_het_project_van_de_klant_in_de_lijst_moeten_voorkomen(String)"
});
formatter.result({
  "duration": 44000,
  "status": "passed"
});
});