# Oferta de disciplinas usando PSR

Projeto da Disciplina Inteligência Artificial. 

A oferta é feita em duas etapas: a primeira aloca as disciplinas aos professores e a segunda aloca o conjunto (disciplina+professor) a um horário. As turmas consistem na combinação de disciplina, professor e horário. A abordagem utilizada baseia-se no uso de PSR's - Problemas de satisfação de restrições e usa a implementação dos PSR's do framework AIMA para JAVA. As restrições levam em consideração o horário de trabalho dos professores e as disciplinas preferenciais dos mesmos. 

![oferta gerada](https://i.imgur.com/y3B5MXW.png)

## Funcionamento 

Primeiramente, é feita a criação de uma nova oferta, onde são definidos os professores e as disciplinas que participarão da oferta:

![configuracao da oferta](https://i.imgur.com/uN4ZKOc.png)

A oferta é feita em duas etapas: a primeira aloca as disciplinas aos professores e a segunda aloca o conjunto (disciplina+professor) a um horário. 
As turmas consistem na combinação de disciplina, professor e horário.

Alocação das disciplinas aos professores:

![professores_disciplinas](https://i.imgur.com/L8KtWli.png)

Em seguida é feita a alocação dos horários, a seguir a grade resultante: 

![grade gerada](https://i.imgur.com/4rbQfrd.png)


