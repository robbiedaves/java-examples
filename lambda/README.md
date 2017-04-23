# Java Examples - Lambda

## Predicates
There are a couple of examples using Predicates.

### Animal Example
Consider we have a collection of animals.
Each animal has a canHop and canSwim property.
If we wanted to filter the collection, before we had lambda functions, we would have to create an Interface (see CheckTrait in example).
The Interface will have a single method called test(Animal a)...
We can implement this interface, like we have done with CheckIfHopper.

However, we can now use Lambda functions to implement the same functionallity without the need to create an interface.
```java
printWithPredicate(List<Animal> animals, Predicate<Animal> checker)
...
            if (checker.test(animal)) {
                System.out.println(animal + " ");
            }
```

### Bank Example
Here is another simple example of the use of Predicates to filter a list of accounts.
```
printAccounts(getAccounts(acc -> acc.getBalance() > 300),  "Accounts with balances > 300");

public List<Account> getAccounts(Predicate<Account> filter) {...
```
