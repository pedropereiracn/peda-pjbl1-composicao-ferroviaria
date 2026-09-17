# Valores esperados para validação

O enunciado diz que a composição padrão do Anexo "será utilizada para validar
os cálculos do programa". Ela é o nosso caso de teste.

## Composição padrão (Anexo)

| Vagão | Qtde | Comp. (m) | Peso (t) | HP | Passag. | Carga (t) |
|---|---|---|---|---|---|---|
| Locomotiva | 1 | 20 | 150 | 2500 | - | - |
| Passageiros | 50 | 24 | 40 | - | 30 | - |
| Carga | 30 | 17 | 20 | - | - | 15 |

## Resultados esperados

| Método | Valor esperado |
|---|---|
| total de vagões (`getSize`) | **81** |
| `contarLocomotivas()` | **1** |
| `contarVagoesPassageiros()` | **50** |
| `contarVagoesCarga()` | **30** |
| `calcularComprimentoTotal()` | **1890 m** |
| `calcularPesoTotal()` | **2750 t** |
| `calcularTotalPassageiros()` | **1500** |
| `calcularCargaTotal()` | **450 t** |
| relação potência/peso | **0,909 HP/t** |
| potência suficiente? | **NÃO** (mínimo 1,05) |
| potência faltando | **387,50 HP** |
| locomotivas a adicionar | **1** |

## As contas, abertas

**Comprimento:**
```
vagões:  1×20 + 50×24 + 30×17 = 20 + 1200 + 510 = 1730 m
espaços: 81 vagões  ->  80 espaços  ->  80 × 2 = 160 m
total:   1730 + 160 = 1890 m
```

> Armadilha: com 81 vagões existem **80** espaços, não 81. Usar 81 dá 1892 m.

**Peso:**
```
1×150 + 50×40 + 30×20 = 150 + 2000 + 600 = 2750 t
```

**Carga:** 30 vagões × 15 t = 450 t. Confere com a regra dos 75%: 75% de 20 t = 15 t.

**Potência:**
```
razão atual   = 2500 / 2750       = 0,909 HP/t   (abaixo de 1,05)
necessário    = 1,05 × 2750       = 2887,50 HP
faltando      = 2887,50 - 2500    = 387,50 HP
```

**Quantas locomotivas adicionar:** cada locomotiva igual soma 2500 HP **e 150 t**.
```
com +1 locomotiva:  5000 / 2900 = 1,724 HP/t   -> passa
```
Resposta: **1 locomotiva**.

> Armadilha: a locomotiva adicionada também entra no peso. Esquecer isso dá
> conta errada.

## Como usar

Antes de implementar cada método, o responsável anota qual número ele tem que
produzir. Implementa. Se sair outro número, o método está errado.

Rodar a bateria completa a cada integração.
