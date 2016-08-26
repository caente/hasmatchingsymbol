# hasmatchingsymbol
project to show a bug

It does not compile when the typeclass and the cases classes are not in the same file. 

If I move the case classes to lib.scala (where the typeclass is), everything works nicely

```
[info] /Users/caente1/workshop/hasMatchingSymbol/src/main/scala/main.scala:8: shapeless.this.Generic.materialize is not a valid implicit value for shapeless.Generic.Aux[models.Foo,G] because:
[info] hasMatchingSymbol reported error: Sealed trait models.Foo has no case class subtypes
[info]   println(foos.map(Add[Foo].add))
[info]                       ^
[info] /Users/caente1/workshop/hasMatchingSymbol/src/main/scala/main.scala:8: bar.this.Ad

d.generic is not a valid implicit value for bar.Add[models.Foo] because:
[info] hasMatchingSymbol reported error: could not find implicit value for parameter gen: shapeless.Generic.Aux[models.Foo,G]
[info]   println(foos.map(Add[Foo].add))
[info]                       ^
[info] /Users/caente1/workshop/hasMatchingSymbol/src/main/scala/main.scala:8: shapeless.this.Generic.materialize is not a valid implicit value for shapeless.Generic.Aux[models.Foo,G] because:
[info] hasMatchingSymbol reported error: Sealed trait models.Foo has no case class subtypes
[info]   println(foos.map(Add[Foo].add))
[info]                       ^
[info] /Users/caente1/workshop/hasMatchingSymbol/src/main/scala/main.scala:8: bar.this.Add.generic is not a valid implicit value for bar.Add[models.Foo] because:
[info] hasMatchingSymbol reported error: could not find implicit value for parameter gen: shapeless.Generic.Aux[models.Foo,G]
[info]   println(foos.map(Add[Foo].add))
[info]                       ^
[error] /Users/caente1/workshop/hasMatchingSymbol/src/main/scala/main.scala:8: could not find implicit value for evidence parameter of type bar.Add[models.Foo]
[error]   println(foos.map(Add[Foo].add))
[error]                       ^
[error] one error found
[error] (compile:compileIncremental) Compilation failed
```
