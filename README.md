# ethereum-explorer
Simple (very very pre-alpha version) command line Ethereum blockchain explorer

Invoke command example:
```{r, engine='bash', count_lines}
java it.databiz.ethereum.EthereumExplorer -h http://localhost -p 8008 -a 0x7122cf4bc0a0db413f6f9e3b3427f461f6f26da8 -f
```

Expected result:

| # |                                Hash                                |                     To                     | Amount (Ether) |         Time        |
|:-:|:------------------------------------------------------------------:|:------------------------------------------:|:--------------:|:-------------------:|
| 1 | 0x473ad2cebd2690604974890fd9ba422706edefe7fab2bf09091edbb335e11987 | 0x5805cd2efd2603f97bf3b854f3ca3f2503640368 |       24.99895 | 2016-01-27 17:51:55 |
| 2 | 0x5d4530365c5e5062d00e266c06816658e031abdfe2f04ec5b6ca7bd0131cd400 | 0x5805cd2efd2603f97bf3b854f3ca3f2503640368 |             20 | 2016-01-27 17:51:03 |
| 3 | 0x0d93b8f3ff81757c0a44557a337a94e29ad40dd5810ddfddd78c4a6da5d33f43 | 0xb5847d3bd457779a3f3331b9982e0d00e28bab72 |       824.9955 | 2016-01-27 17:38:57 |
