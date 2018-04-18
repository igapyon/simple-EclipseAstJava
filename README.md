[target](http://www.igapyon.jp/igapyon/diary/2018/ig180417.html) 

2018-04-17 diary: Eclipse AST を利用した シンプルな Java ソースコード解析
=====================================================================================================
[![いがぴょん画像(小)](http://www.igapyon.jp/igapyon/diary/images/iga200306s.jpg "いがぴょん")](http://www.igapyon.jp/igapyon/diary/memo/memoigapyon.html) [いがぴょん](http://www.igapyon.jp/igapyon/diary/memo/memoigapyon.html)の日記に関連のあるコンテンツ。

## Eclipse AST を利用した シンプルな Java ソースコード解析

Eclipse AST を利用した Java ソースコード解析の最新な状況をメモしておきます。

まず、ここで調べた結果は以下の github リポジトリに反映済みです。

* [https://github.com/igapy...ipseAstJava](https://github.com/igapyon/simple-EclipseAstJava)

### Eclipse AST に必要な jar ライブラリを利用

Eclipse AST を利用するためには、Eclipse AST に関連する jar ライブラリ一式を揃える必要があります。これは Maven リポジトリを利用すると大変簡単に実現することができます。

Maven の依存関係に、以下のように `org.eclipse.jdt.core` を加えます。これだけで、芋づる式に必要な jar ライブラリを利用することが可能になります。

```xml
<dependency>
  <groupId>org.eclipse.jdt</groupId>
  <artifactId>org.eclipse.jdt.core</artifactId>
  <version>3.13.102</version>
</dependency>
```java

### シンプルな Eclipse AST コード

Eclipse AST に必要なライブラリ一式が組み込めたら、Eclipse AST を利用したパースコードが記述および実行できます。重要な箇所を以下にピックアップします。

```java
import org.apache.commons.io.FileUtils;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.CompilationUnit;

        final ASTParser parser = ASTParser.newParser(AST.JLS10);
        parser.setKind(ASTParser.K_COMPILATION_UNIT);
    parser.setSource(buf.toString().toCharArray());

        final CompilationUnit node = (CompilationUnit) parser.createAST(null);
        final SimpleVisitor visitor = new SimpleVisitor();
        node.accept(visitor);
```

完全なソースコードは [https://github.com/igapy...ipseAstJava](https://github.com/igapyon/simple-EclipseAstJava) にて参照することができます。

### 関連する情報

* [2016-10-22 diary: Eclipse AST を利用した Java ソースコード解析](http://www.igapyon.jp/igapyon/diary/2016/ig161022.html) : 旧バージョン
* [2016-10-23 diary: Eclipse AST を利用した PHP ソースコード解析](http://www.igapyon.jp/igapyon/diary/2016/ig161023.html)
