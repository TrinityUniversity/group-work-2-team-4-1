package util

object CodeGen extends App {
  slick.codegen.SourceCodeGenerator.run(
    "slick.jdbc.PostgresProfile", 
    "org.postgresql.Driver",
    "jdbc:postgresql://localhost/inclass?user=mbarton&password=password",
    "C:/Users/charg/WebApps/group-work-2-team-4-1/server/app", 
    "models", None, None, true, false
  )
}