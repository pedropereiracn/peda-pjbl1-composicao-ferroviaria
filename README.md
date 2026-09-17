# PjBL 1 — Composição Ferroviária

Programação com Estruturas de Dados Avançadas (PCO150) · Prof. Dalton Kozak · 2026/2

Aplicação de **deque**: uma composição ferroviária é montada adicionando e retirando
vagões pelas duas extremidades.

**Entrega: 23/09/2026** pelo Canvas, através do grupo previamente cadastrado.

---

## O que entregar

- os arquivos `*.java` com o código fonte das classes (**sem criar pacotes**)
- o arquivo `*.dat` com a composição já criada, **diferente da composição padrão,
  mas construída a partir dela**

## Estado atual

O repositório está na **fase de contrato**: todas as classes existem com as
assinaturas do diagrama de classes do enunciado, os corpos vazios marcados com
`TODO`, e **o conjunto compila**.

```bash
cd src
javac -encoding UTF-8 -d ../out *.java
java -cp ../out ProgramaFerrovia
```

Regra do grupo: **ninguém muda assinatura sem avisar.** Elas vieram do diagrama
do professor e a nota do requisito 11 depende delas.

## Arquivos

| Arquivo | Origem | Mexer? |
|---|---|---|
| `Deque.java` | nossa implementação da prática 04J | **não**, requisito 10b |
| `ObjetoPersistente.java` | fornecida pronta pelo professor | **não** |
| `Vagao.java` e filhas | esqueleto do diagrama | sim, implementar |
| `ComposicaoFerroviaria.java` | esqueleto do diagrama | sim, implementar |
| `ProgramaFerrovia.java` | esqueleto | sim, implementar |

## Armadilha conhecida

O enunciado, no método `carregar()`, escreve:

```java
this.ip = cf.ip;
```

A classe `Deque` da prática declara o ponteiro de percurso como **`ptr`**, não `ip`.
Copiar a linha literalmente **não compila** (`cannot find symbol: variable ip`).
Usar `this.ptr = cf.ptr;`.

## Documentos

- [`docs/REQUISITOS.md`](docs/REQUISITOS.md) — os 12 requisitos e a rubrica
- [`docs/DIVISAO.md`](docs/DIVISAO.md) — divisão do trabalho entre os 4
- [`docs/TESTES.md`](docs/TESTES.md) — valores esperados para validação
