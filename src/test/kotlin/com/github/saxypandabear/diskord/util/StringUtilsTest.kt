package com.github.saxypandabear.diskord.util

import org.junit.Test

class StringUtilsTest {
    @Test fun `mkString should properly iterate over multiple strings`() {
        val result = StringUtils.mkString(" ", "hello", "world", "!")
        assert("hello world !" == result)
    }
}