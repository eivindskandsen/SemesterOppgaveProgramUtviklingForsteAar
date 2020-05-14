# SemesterOppgaveProgramUtviklingForsteAar

Vi bruker Sdk/Jdk verson 1.8.0_242 

 

Du maa kanskje adde JUnit 5.4 til classpath, her er en link til hvordan det gjoeres (se oppdatering)

Du maa kanskje gjoere det manuelt 


https://www.jetbrains.com/help/idea/configuring-testing-libraries.html 

Du kan bruke
 org.junit.jupiter:junit-jupiter:5.4.2
bibloteket

Oppdatering:
Vi har hatt noen problemer med import statementene med j.unit. Derfor har vi valgt å kommentere ut RegexTest  for at programmet skal kjøres enklere

Vi har også hatt noen problemer med aa faa kjoert programmet, ved at kjoer knappen blir borte. Aa skru intelij av og paa/eller bytte til riktig
 SDK ser ut til aa fikse problemet.



Programmet starter to vinduer som ligger oppå hverandre. Superbrukeren saver både binert og tekstfil. For å hente ut oppdaterte komponenter
i utvalg listen må man save først. Fordi "Last inn komponenter" henter fra fil. Vi fikk ikke til å laste opp i binær fil, så vi bruker en
txtfil for å vise at den laster opp i en tråd.