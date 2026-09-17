# Divisão do trabalho

Quatro frentes, definidas pelo diagrama de classes. A regra que evita o
desastre de integração: **a fase 0 é feita pelos quatro juntos**, e depois
ninguém muda assinatura sem avisar no grupo.

## Fase 0 — o contrato ✅ feita

Todas as classes criadas com as assinaturas do diagrama, corpos vazios, e o
conjunto compilando. Já está neste repositório.

## As quatro frentes

### A — Hierarquia de vagões
`Vagao.java` · `Locomotiva.java` · `Passageiro.java` · `Carga.java`

Quatro classes pequenas e parecidas. É a base de que todos dependem, então
**tem que terminar primeiro**. Quem estiver mais inseguro pega esta.

Pontos: sustenta os requisitos 9 e 11.

Detalhes: `Carga` calcula a carga como 75% do peso no construtor.
Nas filhas, `super.imprime()` vem **por último**.

### B — Persistência e estrutura
construtor · `salvar()` · `carregar()` · `inserirInicio/Fim` · `removerInicio/Fim`

**A frente mais arriscada.** Requisitos 1, 3 e 10, e é aqui que mora o
desconto de -3,0 por carregamento incorreto.

Teste obrigatório: criar composição, fechar o programa, abrir de novo e
conferir se voltou igual.

Atenção ao `ptr` versus `ip` (ver README).

### C — Contabilizações e diagnóstico
as 7 privadas · `verificarPotencia()` · `diagnostico()`

**A frente mais pontuada: 4,0.** Requisitos 4 a 8.

Os sete primeiros métodos são o mesmo laço com `instanceof`, mudando o tipo e
o método chamado. O professor deu `contarCargaTotal()` pronto na seção 3.4.2
como modelo. Depois do primeiro, os outros saem rápido.

Manter os métodos **privados**: é o que cumpre o requisito 8.

### D — Programa e composição padrão
`ProgramaFerrovia.java` · `criarComposicaoPadrao()` · `primeiroVagao/ultimoVagao`

Requisitos 2, 9 e 12, somando 3,0. Depende de A e B, então começa pelo menu
com opções vazias e vai plugando conforme os outros entregam.

`criarComposicaoPadrao()` vale 2,0 sozinho. O professor deu o esqueleto dele
na seção 3.4.4.

## Cronograma sugerido

| Dia | A | B | C | D |
|---|---|---|---|---|
| 1 | contrato, os quatro juntos | | | |
| 2-3 | termina os vagões | `carregar`/`salvar` | 2 contabilizações | menu |
| 4 | revisa e faz o `.dat` | inserir/remover | o resto | composição padrão |
| 5 | **integração, os quatro juntos, roda `docs/TESTES.md`** | | | |
| 6 | **cada um explica sua parte para os outros três** | | | |

O dia 6 não é opcional: a Prova 1 é no dia seguinte à entrega e cobra 2,0
pontos de compreensão do programa inteiro.

## Checklist de entrega

- [ ] todos registrados no grupo do Canvas
- [ ] arquivos `*.java`, sem pacotes
- [ ] arquivo `*.dat` com composição **diferente da padrão, construída a partir dela**
- [ ] a bateria de `docs/TESTES.md` passa inteira
- [ ] carregamento inicial testado fechando e reabrindo o programa
- [ ] declaração de uso de IA, conforme Res. 274/2024 CONSUN
- [ ] cada integrante consegue explicar qualquer parte do código
