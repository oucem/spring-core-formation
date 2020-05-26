Guide de review
===================

Bonnes pratiques
----------------

* La review doit s'intéresser au respect des bonnes règles de codage, mais **également à la bonne implémentation
  du fonctionnel demandé**. Lire l'US associée à la merge request. Ne pas hésiter
  à remonter d'éventuels trous dans la raquette ou d'oublis de cas fonctionnels.
* Descendre la branche sur son poste de dev, pour faciliter l'analyse de code avec IntelliJ/Eclipse :
  * Le parcours d'une méthode à une autre est beaucoup plus facile.
  * IntelliJ/Eclipse (sonarQube) analyse le code et remonte des alertes.
  * Réaliser quelques tests en local, pour mieux comprendre l'aspect fonctionnel de la story testée.
* Pas d'insultes. Rédiger des commentaires constructifs :-)


Contrôle des messages de commits
--------------------------------

* Les messages de commit doivent contenir l'ID de l'US Jira/Trello (but : traçabilité).
  * Bon message : _[MYStory-12345] Ouverture de boutique
  * Mauvais message : _Update docker.json_
* Les messages de commit expliquent les changements apportés (but : comprendre le code en parcourant l'historique)


Développements backend
----------------------

### Code source

* Attention au modèle commun :
  * Prévenir les clients de l'API (frontEnd, partenaire, etc) si des changements non rétro-compatibles sont apportés.
  * Annoter correctement le modèle pour limiter le nombre de champs sérialisés en JSON (`@JsonIgnore` ou `@JsonView Private`).
* Pas de nouvelle alerte Sonar introduite : http://sonar/dashboard?id=....
* Utiliser le pattern [Null Object](https://sourcemaking.com/design_patterns/null_object) pour les getters qui renvoient
  des listes. Le but est de se passer de contrôles de nullité sur les listes, afin de faciliter leur exploitation dans des
  _Stream_ Java.
* Inputs des API:
  * Ne pas utiliser les objets du modèle commun. Créer des objets dédiés pour bien distinguer les Dto des modèles metiers.
  * Validation surfacique avec Hibernate Validator? peut être
  * Complément de validation possible, en créant une commande dédiée à la validation des inputs.
  * Pour voir un bon exemple de cette stratégie de validation, voir la classe `DoSomething`.
* Obfuscation des informations sensibles dans les logs :
  * Certaines informations sensibles doivent être obfusquées dans les logs : n° et CVV de carte bancaire, prénoms, noms, n° CNI.
  * Vérifier la bonne obfuscation de ces informations dans les logs.
* Développement autour des messages à destination du Kafka:
  * Faire des évolution rétro-compatibles autant que possible, pour faciliter l'intégration du modèle (c'est à dire :
    éviter les suppressions ou les renommages de champ).
  * En cas d'évolution non-rétrocompatible, incrémenter dans les propriétés la version du topic Kafka dans lequel on vas écrire.

### Tests unitaires

* Utiliser le _code coverage_ d'Intellij pour contrôler que le code modifié est correctement couvert.
  Un objectif du 80% de couverture est souhaitable.
* Des assertions contrôlent les résultats des tests
* Les assertions sont toutes écrites en utilisant [AssertJ](https://assertj.github.io/doc/).
  Ne pas utiliser les assertions JUnit (pour faire en sorte d'harmoniser nos assertions).
* Ecriture en mode BDD :

```java
// given

// Je prépare mon jeu de données
// Je prépare un autre jeu de données
// ...

// when

// J'exécute ma seule et unique action

// then

// Je vérifie le résultat de mon action
// Je vérifie un autre résultat de mon action
// ...
```


Développements frontend
----------------------

### Code source

* Reducers Redux :
  * Uniquement des fonctions _pures_ pour les fonctions _reduce_
  * Les effets de bord (appels HTTP, génération d'une variable random) doivent être fait dans les _action creators).


### Tests unitaires


* Utiliser le _code coverage_ d'Intellij pour contrôler que le code modifié est correctement couvert
  (le coverage fonctionne aussi pour les tests Jest).
  Un objectif du 80% de couverture est souhaitable.
* Composants graphiques React :
  * Des exemples d'utilisation des  doivent être présents dans les storybooks. Les exemples sont
    ensuite utilisés pour des tests de non-régression de structure (tests _storyshot_).
  * Bien relire des diffs sur les storyshots, vérifier les évolutions sur la structure HTML


Tests E2E
---------

**TODO :** décrire les bonnes pratiques pour les tests E2E côté back, ainsi que les tests E2E cypress 


Tests de performance / de charge
--------------------------------

* Les scénarios Gatling de performance / de charge ont été mis à jour s'il y a eu des évolutions d'API non
  rétro-compatibles.
* Si un nouveau partenaire appelable en HTTP est ajouté => créer des nouvelles entrées dans le serveur de mock


Configuration sur les plateformes hors-prod / production
--------------------------------------------------------

* Les données sensibles (mots de passe, clés d'API, par exemple) sont annotés dans les templates de propriétés.
* Les fichiers de propriétés JSON devront être renseignés.
  Exception : les données sensibles (mots de passe, clés d'API, par exemple) **pour la production** restent déclarées
  uniquement dans les templates ; on ne doit pas les retrouver dans les fichiers de configuration JSON.
* Ne pas utiliser les propriétés itérables

Monitoring
----------
TODO
