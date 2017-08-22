package password

import org.apache.commons.codec.digest.Crypt
import org.apache.commons.lang.RandomStringUtils

object PasswordInfo {
  val SALT_LENGTH:Int = 16
  val SALT_PREFIX:String = "$5$"

  def hash(password:String):String = Crypt.crypt(password,generateSHA256Salt)
  def matches(password:String,hash:String):Boolean = {
    val pwdTokens = """(.{3})([a-zA-Z0-9]+)\$(.+)""".r
    val pwdTokens(prefix, salt, hashedPwd) = hash
    hash == Crypt.crypt(password,prefix+salt)
  }

  def generateSHA256Salt = SALT_PREFIX+RandomStringUtils.randomAlphanumeric(SALT_LENGTH)
}

