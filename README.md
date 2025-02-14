# Linea tracer (zkEVM)

This repository hosts a Linea tracing implementation for 
[Besu](https://github.com/hyperledger/besu) based on an 
 implementation in Go.

Tracing refers to the process of extracting data from the execution of an EVM client in order to construct large matrices known as execution traces. Execution traces are subject to the constraint system specified in the [linea-specification](https://github.com/Consensys/linea-specification) repo and implemented in the [linea-constraints](https://github.com/Consensys/linea-constraints) repo.

It serves developers by making the Linea tech stack open source under 
the [Apache 2.0 license](LICENSE).

## What is Linea?

[Linea](https://linea.build) is a developer-ready layer 2 network scaling Ethereum. It's secured with a zero-knowledge rollup, built on lattice-based cryptography, and powered by [Consensys](https://consensys.io).

## Get started

If you already have an understanding of the tech stack, use our [Get Started](docs/get-started.md) guide.

### Looking for plugins?

Discover [existing plugins](docs/plugins.md) and understand the [plugin release process](docs/plugin-release.md). 

## Looking for the Linea code?

Linea's stack is made up of multiple repositories, these include:
- This repo, [linea-tracer](https://github.com/Consensys/linea-tracer): Linea-Besu plugin which produces the traces that the constraint system applies and that serve as inputs to the prover
>
> This repository contains the elements of the Linea stack responsible for this process.
- [linea-monorepo](https://github.com/Consensys/linea-monorepo): The main repository for the Linea stack & network 
- [linea-besu](https://github.com/Consensys/linea-besu): Fork of Besu to implement the Linea-Besu client
- [linea-sequencer](https://github.com/Consensys/linea-sequencer): A set of Linea-Besu plugins for the sequencer and RPC nodes
- [linea-constraints](https://github.com/Consensys/linea-constraints): Implementation of the constraint system from the specification
- [linea-specification](https://github.com/Consensys/linea-specification): Specification of the constraint system defining Linea's zkEVM

Linea abstracts away the complexity of this technical architecture to allow developers to:

- [Bridge tokens](https://docs.linea.build/developers/guides/bridge)
- [Deploy a contract](https://docs.linea.build/developers/quickstart/deploy-smart-contract)
- [Run a node](https://docs.linea.build/developers/guides/run-a-node)

... and more.

## How to contribute

Contributions of any kind are welcome!

1. [Create an issue](https://github.com/Consensys/linea-arithmetization/issues).
> If the proposed update is non-trivial, also tag us for discussion.
2. Submit the update as a pull request from your [fork of this repo](https://github.com/Consensys/linea-arithmetization/fork), and tag us for review. 
> Include the issue number in the pull request description and (optionally) in the branch name.

Consider starting with a ["good first issue"](https://github.com/ConsenSys/linea-arithmetization/issues?q=is%3Aissue+is%3Aopen+label%3A%22good+first+issue%22).

Before contributing, ensure you're familiar with:

- Our [Linea contribution guide](https://github.com/Consensys/linea-monorepo/blob/main/docs/contribute.md)
- Our [Linea code of conduct](https://github.com/Consensys/linea-monorepo/blob/main/docs/code-of-conduct.md)
- The [Besu contribution guide](https://wiki.hyperledger.org/display/BESU/Coding+Conventions), for Besu:Linea related contributions
- Our [Security policy](https://github.com/Consensys/linea-monorepo/blob/main/docs/security.md)


### Useful links

- [Linea docs](https://docs.linea.build)
- [Linea blog](https://linea.mirror.xyz)
- [Support](https://support.linea.build)
- [Discord](https://discord.gg/linea)
- [Twitter](https://twitter.com/LineaBuild)

### Update reference tests

To update the reference tests, run the following commands:

```shell
cd reference-tests/src/test/resources/ethereum-tests
git fetch
git checkout <branch or commit>
# update LegacyTests submodule of new commit
git submodule update --init --recursive
# go back to project root
cd ../../../../..
git add reference-tests/src/test/resources/ethereum-tests/
git commit -m "<commit message>"
```