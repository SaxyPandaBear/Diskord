package com.github.saxypandabear.diskord.util

import org.junit.Test

class StringUtilTest {
    @Test
    fun `mkString should properly iterate over multiple strings`() {
        val result = StringUtil.mkString(" ", "hello", "world", "!")
        assert("hello world !" == result)
    }
}