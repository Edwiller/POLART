# 🌡️ POLART - Plataforma Online para Leitura, Análise e Registro de Temperatura

Projeto desenvolvido para a disciplina de **Programação Orientada a Objetos (POO)** do curso de **Sistemas para Internet** do **Instituto Federal do Acre (IFAC)**.

O sistema simula o funcionamento de uma plataforma de monitoramento de temperatura em salas refrigeradas, permitindo o gerenciamento de sensores, leituras, alertas e manutenções, aplicando os principais conceitos de Programação Orientada a Objetos em Java.

---

## 👥 Integrantes

* Edwiller de Lima Araujo

**Professor:** Jonas da Conceicao Nascimento Pontes

---

# 📌 Objetivo

Desenvolver um sistema orientado a objetos capaz de automatizar processos básicos de monitoramento de temperatura, como:

* Cadastro de salas refrigeradas;
* Cadastro de sensores;
* Registro de leituras de temperatura;
* Emissão de alertas em caso de temperatura fora da faixa ideal;
* Registro de manutenções;
* Consulta ao histórico de leituras.

Todo o armazenamento é realizado em memória, utilizando coleções do Java (`List`), simulando um banco de dados.

---

# 📋 Requisitos Funcionais

| Código | Descrição |
|---------|-----------|
| RF01 | Cadastrar salas refrigeradas |
| RF02 | Cadastrar sensores vinculados às salas |
| RF03 | Registrar leituras de temperatura |
| RF04 | Emitir alertas de temperatura crítica |
| RF05 | Registrar manutenções de sensores e salas |
| RF06 | Consultar histórico de leituras e alertas |
| RF07 | Gerenciar usuários (administradores e operadores) |

---

# 🧩 Modelagem

O projeto foi modelado utilizando UML.

### Diagrama de Classes

O diagrama contempla:

- Herança entre Usuario, Administrador e Operador;
- Associação entre Sala Refrigerada e Sensor;
- Composição entre Sensor e Temperatura;
- Composição entre Sensor e Alerta;
- Agregação entre Empresa, Salas Refrigeradas e Sensores;
- Realização da interface Autenticavel pelos Usuários.

### Diagrama de Máquina de Estados

Foi desenvolvido um diagrama para representar o ciclo de vida de uma Sala Refrigerada, desde sua ativação até uma eventual manutenção ou estado crítico.

---

# ✨ Funcionalidades

## Cadastro de Salas Refrigeradas

* Cadastro de nome, localização, empresa responsável e faixa ideal de temperatura;
* Impede cadastro de sala duplicada;
* Vinculação de sensores à sala;
* Listagem de todas as salas cadastradas;
* Consulta de status da sala.

---

# 💻 Tecnologias Utilizadas

- Java
- Programação Orientada a Objetos
- UML
- Git
- GitHub

---

## Registro de Sensores e Leituras

Regras implementadas:

* Cada sensor deve estar vinculado a uma sala refrigerada;
* Cada leitura gera um novo registro de temperatura;
* Verificação automática se a leitura está dentro da faixa ideal.

---

## Controle de Alertas

O sistema mantém um monitoramento organizado por sala e sensor.

Cada sala possui um ciclo de vida representado pelos seguintes estados:

* ATIVA
* EM_ANALISE
* NORMAL
* ATENCAO
* CRITICA
* EM_MANUTENCAO
* INATIVA

Também é possível:

* Consultar o status completo das salas;
* Registrar ocorrências de alertas;
* Listar todos os sensores cadastrados;
* Emitir alertas quando a temperatura atingir nível crítico.

---

## Histórico de Leituras

Permite consultar todas as leituras de temperatura registradas durante a execução do sistema.

Cada registro contém:

* Código da leitura;
* Sensor responsável;
* Data e hora;
* Valor da temperatura registrada.

---

# 🛡️ Validações Implementadas

O sistema realiza diversas validações para garantir a consistência dos dados.

### Cadastro

* Sala não pode ser duplicada;
* Sensor deve estar vinculado a uma sala existente.

### Leitura

* Valor de temperatura deve estar dentro de limites plausíveis;

### Alertas

* Não permite registrar leitura sem sensor associado;
* Emite alerta quando a temperatura ultrapassa o limite definido para a sala.

---

# 🧩 Conceitos de Programação Orientada a Objetos Aplicados

O projeto foi desenvolvido utilizando os principais pilares da Programação Orientada a Objetos.

### Encapsulamento

Os atributos das classes são privados, sendo acessados por meio de métodos públicos (getters e setters quando necessário).

### Herança

A classe `Usuario` é utilizada como classe base para:

* Administrador
* Operador

evitando repetição de atributos comuns.

### Polimorfismo

Implementação de interfaces para abstração de comportamentos, permitindo maior flexibilidade do sistema.

### Interfaces

Foi utilizada:

* `Autenticavel`

para representar a responsabilidade de autenticação dentro da aplicação.

### Coleções

Utilização de coleções do Java para simular a persistência dos dados:

* List: utilizada para armazenar salas, sensores, leituras de temperatura e alertas.
* Map: utilizada para gerar o resumo do monitoramento, relacionando cada sala ao seu status atual.

---

# ⚠️ Exceções Personalizadas

O sistema utiliza exceções customizadas para representar situações específicas:

* `SalaException`
* `SensorException`
* `TemperaturaException`
* `AlertaException`
* `ManutencaoException`
* `UsuarioException`

---

# ▶️ Como Executar

1. Clone este repositório.
git clone https://github.com/Edwiller/POLART

2. Abra o projeto em uma IDE Java (IntelliJ IDEA, Eclipse ou NetBeans).

3. Execute a classe:
Main.java

4. Utilize o menu interativo exibido no console.

---

# 📚 Tecnologias Utilizadas

* Java
* Programação Orientada a Objetos
* Coleções (`List`)
* Tratamento de Exceções
* UML (Casos de Uso, Diagrama de Classes e Máquina de Estados)