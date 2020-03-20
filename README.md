# BbsApp  


リンク→https://fathomless-spire-50882.herokuapp.com/  


プログラミングについて自由に掲示板作成やコメント書き込みができる会員制掲示板WEBアプリです。  


It is a membership system bulletin board WEB application that can freely create a bulletin board and write comments about programming.

画像1  
![スクリーンショット (6)](https://user-images.githubusercontent.com/61927393/77175597-3ae0ac80-6b06-11ea-81db-d3c69f1393b3.png)

画像2  
![スクリーンショット (9)](https://user-images.githubusercontent.com/61927393/77176432-7334ba80-6b07-11ea-9815-6c67c17751b9.png)

画像3  
![スクリーンショット (10)](https://user-images.githubusercontent.com/61927393/77176451-7af45f00-6b07-11ea-8309-fa64f594f71c.png)



## Description  
職業訓練校で掲示板WEBアプリの作成が課題として出され、何かテーマを決めればイメージが湧きやすく、また作っていて楽しいだろうと考えた。
その結果、どんな些細なことから深く議論しなければならないことでも自由に話し合え、解決につなげられる掲示板アプリを作成することにした。


Servlet/JSPを利用した。    
modelクラス、Servletクラス、JSPがそれぞれMVCモデルの何にあたり、何をしているのか・どう役割が分かれているのかの理解を深めることができた。

WEBアプリの基本的な機能を一から開発することで仕組みを理解したり、実装する力が身についた。  

HTML/CSSも学び始めたばかりであったが、参考書や調べるなどしてデザインを整え、使いやすいUIを意識した。また、レスポンシブデザインにも対応させた。 

訓練終了後にGit、GitHub、Herokuなどを独習し公開するに至った。


#### 苦労したところ
<ul>
  <li>データベースで複数のテーブルにforeign keyを設定したため、ユーザー削除の場合に対象ユーザーのコメント削除スレッド削除を先に行う必要があったが初めそれに気付かず長い時間悩んだ</li>
  <li>指定したプログラミング言語のスレッドを取得するときなどのSQL文をどうすればよいか</li>
  <li>session.setAttribute()とrequest.setAttribute()の使い分けが初めよく分かっておらず、ログイン失敗時などのエラーメッセージ表示で思った通りにいかないことがあった</li>
  <li>CSSでのデザイン全般。HTMLを見直しノートに全体像を書き出しブロック分けをして、クラス名の記入もしてから組み立てていったところ、うまくいくようになった</li>
  <li>レスポンシブデザインへの対応。Googleデベロッパーツールでスマートフォン、タブレットでの画面表示の確認を行ったが、実機で確認するとデザインが崩れることがありそれを直すのに苦労した</li>
  <li>eclipseからGitHubへコミットし、powershellを操作してローカルデータをherokuへアップするまでをネットの情報を参考に行ったが、ところどころうまくいかないことがあった。例えばherokuのデータベースをMySQLにするときの設定変更やMySQLワークベンチでのコネクションの設定、JDBCの設定など</li>
</ul>

## 機能  
### -ユーザーサイド-  
<ul>
  <li>新規登録機能</li>
  <li>ログイン機能</li>
  <li>ログアウト機能</li>
  <li>スレッド全件表示機能</li>
  <li>プログラミング言語別スレッド全件表示機能（タブ切り替え）</li>
  <li>スレッド検索機能</li>
  <li>コメント全件表示機能</li>
  <li>コメント投稿機能</li>
</ul>


### -管理者サイド-
<ul>
  <li>ログイン機能</li>
  <li>ログアウト機能</li>
  <li>ユーザー削除機能（1件ずつ）</li>
  <li>スレッド削除機能（１件ずつ）</li>
  <li>コメント削除機能（1件ずつまたは指定ワードを含むコメント全件削除</li>
</ul>


## 使用した言語・データベース
<ul>
  <li>Java</li>
  <li>HTML</li>
  <li>CSS</li>
  <li>JavaScript</li>
  <li>MySQL</li>
</ul>


