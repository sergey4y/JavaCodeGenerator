JavaCodeGenerator
=================

Generation of java code. As of now only implemented incoming type is simple and easy to write text format.

Example of format:

Home
+getDoorSize(id:int, flag:boolean):double
+getCount():int static
-curCount:int static
#code:String

Here first line "Home" is the name of the class.
"+" - public access modifier, others are "-" - private and "#" - protected
"getDoorSize" - method name
"(id:int, flag:boolean)" - parameters with types
":double" - return type
"-curCount:int static" - static private field of type int
and so on

