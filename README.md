# Rafa Soares' Advent of Code

For a general description of the repo, see [this file in the
`main` branch](https://github.com/rafasoares/adventofcode/blob/main/README.md)

## Kotlin

This branch includes my solutions for the 2025 Advent of Code challenges written in Kotlin.

Each day is split into its own package, with some shared utilities, like handling input files, in the root package.
Inside each package, both part 1 and part 2 solutions are included in the `day**.kt` file. Normally any helpers and
types are also in this file, but they can be extracted into separate files if the solution is complex enough.

For each day, there's a matching file in the root `test` package. I usually test both parts against the test input
separately, but they should work when tested together. I'm using [TestBalloon] to keep test boilerplate to a minimum.

If necessary, any helper methods are also tested inside the relevant day's test suite.

[TestBalloon]: https://github.com/infix-de/testBalloon/
