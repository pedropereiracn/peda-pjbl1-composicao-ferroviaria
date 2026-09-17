# Requisitos e rubrica

## Rubrica (total 10,0)

| # | Requisito | Valor |
|---|---|---|
| 1 | Método para carregamento/gravação | 0,5 |
| **2** | **Método para criar composição padrão** | **2,0** |
| 3 | Métodos para inserção e remoção de vagões | 0,5 |
| 4 | Recuperação do número de vagões e seus subtipos | 0,5 |
| 5 | Contabilização do comprimento e peso totais | 0,5 |
| 6 | Contabilização do número de passageiros e carga total | 0,5 |
| 7 | Verificação se a potência é suficiente e recomendações | 0,5 |
| **8** | **Métodos para diagnóstico (#4 a #7)** | **2,0** |
| 9 | Retornar os dados do primeiro e do último vagão | 0,5 |
| **10** | **Implementação com as classes Deque e ObjetoPersistente indicadas** | **1,5** |
| 11 | Diagrama de classes implementado corretamente | 0,5 |
| 12 | Programa de teste correto | 0,5 |

## Descontos

| # | Desconto | Valor |
|---|---|---|
| 1 | Carregamento inicial incorreto/ausente | **-3,0** |
| 2 | Uso de outra classe Deque distinta da solicitada | -2,0 |
| 3 | Código não original: plágio, IA etc. | -10,0 |
| 4 | Uso de bibliotecas de ED | até -4,0 |
| 5 | Outro recurso não visto em sala | até -4,0 |

> **O item de maior risco do projeto é o requisito 1.** Vale 0,5, mas errá-lo
> custa -3,0. Oscilação de 3,5 pontos. O `carregar()` no construtor tem que
> funcionar: fechar o programa, abrir de novo e a composição tem que voltar.

## Regras do enunciado

- Equipes de **4** componentes, em grupos previamente criados no Canvas.
  Só são aceitos PjBLs enviados pelos grupos cadastrados.
- Usar **apenas** classes, estruturas e recursos estudados na disciplina.
  Não é permitido usar bibliotecas de estruturas de dados do Java em
  substituição às classes fornecidas.
- **Não alterar** os métodos da classe Deque original, apenas utilizá-los.
- Cada integrante deve **compreender o funcionamento completo do programa**,
  mesmo que as tarefas tenham sido divididas.

## Verificação individual

Questão na Prova 1 (24/09) valendo **2,0 pontos**, que não afeta a nota do PjBL.
Podem ser apresentados trechos do programa para **interpretação, complementação
ou correção**.

## Tipos de vagão

| Tipo | Comprimento | Peso | Específico |
|---|---|---|---|
| Locomotiva | 18 a 23 m | 100 a 200 t | potência, 2000 a 6000 HP |
| Passageiro | 22 a 26 m | 30 a 50 t (vagão + passageiros) | até 50 passageiros |
| Carga | 12 a 19 m | 15 a 30 t (vagão + carga) | carga = **75% do peso total** |

Espaço entre vagões: **2 m**. Mínimo aceitável de potência: **HPT = 1,05 HP/Ton**.
