package password

object Main {
  def main(args: Array[String]) = {
    println(args)
    require(args.nonEmpty, "Please provide at least one string to be hashed")

    val hashes = args.map { arg =>
      PasswordInfo.hash(arg)
    }

    println(hashes.mkString("\n"))
  }
}
