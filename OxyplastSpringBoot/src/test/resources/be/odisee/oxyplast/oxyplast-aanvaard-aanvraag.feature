# language: nl
Functionaliteit: Aanvaarden van een aanvraag
  
  Een nieuw project zal worden gestart als de aanvraag wordt aanvaard

  Achtergrond: 
    Gegeven "Hans" is een eerste klant met id=100
    En "Hans" heeft een eerste aanvraag ingediend met naam="test"
    En "Jan" is een tweede klant met id=200
    En "Jan" heeft een tweede aanvraag ingediend met naam="JanDeMan"
    En "Thomas" is een derde klant met id=300
    En "Thomas" heeft een derde aanvraag ingediend met naam="ThomasFirst"
    En er is een project opgestart met de naam "ThomasFirst300"


  Scenario: een aanvraag aanvaarden dat nog niet is aanvaard geweest
    Als De accountverantwoordelijke de aanvraag van "Hans" heeft bekeken en deze aanvaard
    Dan Moet er een project worden gestart waarvan de naam="test100" is en de status="gestart"


  Scenario: een aanvraag afwijzen
    Als De accountverantwoordelijke de aanvraag van "Jan" heeft bekeken en deze afwijst
    Dan mag er geen project worden gestart waarvan de naam="JanDeMan200" is en de status="gestart"


  Scenario: een aanvraag aanvaarden dat al reeds is aanvaard
    Als De accountverantwoordelijke de aanvraag van "Thomas" heeft bekeken en deze aanvaard
    Dan Mag er geen tweede project worden gestart met naam="ThomasFirst300" en de status="gestart"

