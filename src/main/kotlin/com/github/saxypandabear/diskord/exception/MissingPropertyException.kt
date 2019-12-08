package com.github.saxypandabear.diskord.exception

class MissingPropertyException(propertyKey: String) :
    RuntimeException("$propertyKey is missing from the properties for this client")
