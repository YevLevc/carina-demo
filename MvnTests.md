
```
mvn clean idea:idea
```
### Tests run

```
mvn test -Dsuite=web-menus
mvn test -Dsuite=web-login-modal
mvn test -Dsuite=web-login

```

Single class test
```
mvn test -Dtest=WebMenuClickTest
```

Single method
```
mvn test -Dtest=WebMenuClickTest#testMainMenuItems