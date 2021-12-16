# CMLXOM
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/org.blueobelisk/cmlxom/badge.svg)](https://maven-badges.herokuapp.com/maven-central/org.blueobelisk/cmlxom)
[![Build Status](https://github.com/BlueObelisk/cmlxom/actions/workflows/maven.yml/badge.svg)](https://github.com/BlueObelisk/cmlxom/actions/workflows/maven.yml)

A Java library for processing CML,
implementing the XML object model (XOM) for the Chemical Markup Language (CML).

## Releases

Instructions to increase the version:

```shell
mvn versions:set -DnewVersion=1.4-SNAPSHOT
```

Deploy to Sonatype with the following commands, for snapshots and releases respectively:

```sh1ll
mvn clean deploy
mvn clean deploy -P release
```

