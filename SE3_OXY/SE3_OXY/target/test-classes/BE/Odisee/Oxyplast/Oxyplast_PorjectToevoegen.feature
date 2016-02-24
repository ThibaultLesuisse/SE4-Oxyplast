# language: nl

Functionaliteit: Een project toevoegen 

Gegeven: Een accountverantwoordelijke moet eerst een klant toevoegen als er nog geen bestaat.
Dan wordt een aanvraag ingediend die dan moeten worden goedgekeurd en pas daarna kan een project worden 
gestart.

Achtergrond: Indien de klant nog niet bestaat en die wil worden opgenomen in ons klantenbestand

Scenario: De accountverantwoordelijke voegt een klant toe
Als de klant wordt toegevoegd
Dan is de lijst van klanten 1 groot.
En zou de klant "Dubai" in de lijst moeten voorkomen

Scenario: De Klant dient een aanvraag in
Als de aanvraag wordt aangemaakt
Dan moet de Boolean aanvaard op true staan

Scenario: De accountverantwoordelijke start het project op
Als het project wordt toegevoegd
Dan is de lijst van projecten 1 groot
En zou het project "DubaiVerf" van de klant in de lijst moeten voorkomen
 
