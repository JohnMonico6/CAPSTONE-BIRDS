<%@ 
page language="java" 
contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"
import="GameLogic.Card, GameLogic.Pile, GameLogic.Player, GameLogic.DrawHand"
%>

<!DOCTYPE HTML>
<!--
	Ex Machina by TEMPLATED
    templated.co @templatedco
    Released for free under the Creative Commons Attribution 3.0 license (templated.co/license)
-->
<html>
	<head>
		<title>Bird World | Play</title>
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<meta name="description" content="" />
		<meta name="keywords" content="" />
		<link href='http://fonts.googleapis.com/css?family=Roboto+Condensed:700italic,400,300,700' rel='stylesheet' type='text/css'>
		<!--[if lte IE 8]><script src="js/html5shiv.js"></script><![endif]-->
		<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
		<script src="js/skel.min.js"></script>
		<script src="js/skel-panels.min.js"></script>
		<script src="js/init.js"></script>
		<noscript>
			<link rel="stylesheet" href="css/skel-noscript.css" />
			<link rel="stylesheet" href="css/style.css" />
			<link rel="stylesheet" href="css/style-desktop.css" />
		</noscript>
		<!--[if lte IE 8]><link rel="stylesheet" href="css/ie/v8.css" /><![endif]-->
		<!--[if lte IE 9]><link rel="stylesheet" href="css/ie/v9.css" /><![endif]-->
		
		<style>
			#GameTitleScreen {
				border: 3px solid black;
				width:1200px;
				height:700px;
				max-width: 120%;
			}
			
			#PlayButton {
				position: absolute;
				left: 45%;
				top: 25%;
				width: 100px;
				height: 30px;
				max-width: 100%;
			}
			
			#CardLeft {
				position: absolute;
				width: 230px;
				height: 320px;
				left: 22%;
				top: 11%;
				max-width: 100%;
			}
			
			#CardMiddle {
				position: absolute;
				width: 230px;
				height: 320px;
				left: 42%;
				top: 11%;
				max-width: 100%;
			}
			
			#CardRight {
				position: absolute;
				width: 230px;
				height: 320px;
				left: 62%;
				top: 11%;
				max-width: 100%;
			}
			
			#Deck {
				position: absolute;
				background: lightblue;
				left: 20%;
				top: 34.5%;
				width: 860px;
			}
		</style>
		
		<script>			
			function playFunction() {
				var playBtn = document.getElementById("PlayButton");
				var gameTitleScreen = document.getElementById("GameTitleScreen");
			    if (playBtn.style.display === "none" && gameTitleScreen.style.display == "none") {
			        playBtn.style.display = "block";
			        gameTitleScreen.style.display = "block";
			    } else {
			        playBtn.style.display = "none";
			        gameTitleScreen.style.display = "none";
			        
			        document.getElementById("GameBoard").style.display = "block";
			        document.getElementById("Deck").style.display = "block";
			        
			        //Java Code
			        <%
			        		Player player1 = new Player("TheLegend27");
			        		
			        		String image1 = player1.getDrawHand().getCard(0).getImgSource();
			        		String image2 = player1.getDrawHand().getCard(1).getImgSource();
			        		String image3 = player1.getDrawHand().getCard(2).getImgSource();
			        		
			        		%>
					        document.getElementById("CardLeft").src = '<%= image1 %>';
					        document.getElementById("CardMiddle").src = '<%= image2 %>';
					        document.getElementById("CardRight").src = '<%= image3 %>';
			        		<%
			        %>
			    }
			}
			
			function pickCard(index) {
				var pos = index;
				<%
					
				%>
			}
		</script>
	</head>
	<body class="right-sidebar">

	<!-- Header -->
		<div id="header">
			<div class="container">

				<!-- Logo -->
					<div id="logo">
						<h1><a href="#">Bird World - Play</a></h1>
					</div>

				<!-- Nav -->
					<nav id="nav">
						<ul>
							<li><a href="index.html">Homepage</a></li>
							<li class="active"><a href="play.html">Play</a></li>
							<li><a href="news.html">Read</a></li>
							<li><a href="Login_Register.html">Login/Register</a></li>
						</ul>
					</nav>
			</div>
		</div>
	<!-- Header -->

	<!-- Banner -->
		<div id="banner">
			<div class="container">
			</div>
		</div>
	<!-- /Banner -->

	<!-- Main -->
		<div id="page">

	<!-- Game -->
	<div id="game" class="container">
		<div class="row">
			<div class="gameScreen">
				<section>
					<header>
						<h2>Bird Challenge!</h2>
						<span class="byline">Learn bird calls and facts about Birds in this game! (Playable in web browser)</span>
					</header>
					<p>
						<img src="images/BirdGameTitle.png" alt="BirdGame" id="GameTitleScreen">
						<img id="CardLeft" value="Card1" onclick="pickCard()">
						<img id="CardMiddle" value="Card2" onclick="pickCard()">
						<img id="CardRight" value="Card3" onclick="pickCard()">
						<button type="button" id="PlayButton" onclick="playFunction()">Play!</button>
						<div id="GameBoard" style="width:1200px; height:700px; border:3px solid black; display:none;"></div>
						<div id="Deck" style="height:200px; border:3px solid black; display:none;"></div>
					</p>
				</section>
			</div>
		
	<!-- Featured -->
		<div id="featured">
			<div class="container">
				<div class="row">
					<section class="4u">
						<div class="box">
							<a href="#" class="image left"><img src="images/pics04.jpg" alt=""></a>
							<h3>Etiam posuere augue</h3>
							<p>Donec nonummy magna quis risus eleifend. </p>
							<a href="#" class="button">More</a>
						</div>
					</section>
					<section class="4u">
						<div class="box">
							<a href="#" class="image left"><img src="images/pics05.jpg" alt=""></a>
							<h3>Etiam posuere augue</h3>
							<p>Donec nonummy magna quis risus eleifend. </p>
							<a href="#" class="button">More</a>
						</div>
					</section>
					<section class="4u">
						<div class="box">
							<a href="#" class="image left"><img src="images/pics06.jpg" alt=""></a>
							<h3>Etiam posuere augue</h3>
							<p>Donec nonummy magna quis risus eleifend. </p>
							<a href="#" class="button">More</a>
						</div>
					</section>
				</div>
				<div class="divider"></div>
			</div>
		</div>
	<!-- /Featured -->

	<!-- Footer -->
		<div id="footer">
			<div class="container">
				<div class="row">
					<div class="3u">
						<section>
							<h2>Bird Quote of the Day</h2>
							<div class="balloon">
								<blockquote>&ldquo;&nbsp;&nbsp;"Those little nimble musicians of the air, that warble forth their curious ditties, with which nature hath furnished them to the shame of art."&nbsp;&nbsp;&rdquo;<br>
									<br>
									<strong>&ndash;&nbsp;&nbsp;Izaak Walton</strong></blockquote>
							</div>
							<div class="ballon-bgbtm">&nbsp;</div>
						</section>
					</div>
					<div class="3u">
						<section>
							<h2>Donec dictum</h2>
							<ul class="default">
								<li>
									<h3>Mauris vulputate dolor sit amet</h3>
									<p><a href="#">Donec leo, vivamus fermentum nibh in augue praesent a lacus at urna congue rutrum.</a></p>
								</li>
								<li>
									<h3>Fusce ultrices fringilla metus</h3>
									<p><a href="#">Donec leo, vivamus fermentum nibh in augue praesent a lacus at urna congue rutrum.</a></p>
								</li>
								<li>
									<h3>Donec dictum metus in sapien</h3>
									<p><a href="#">Donec leo, vivamus fermentum nibh in augue praesent a lacus at urna congue rutrum.</a></p>
								</li>
							</ul>
						</section>
					</div>
					<div class="3u">
						<section>
							<h2>Nulla leifend</h2>
							<p>Donec placerat odio vel elit. Nullam ante orci, pellentesque eget, tempus quis, ultrices in, est. Curabitur sit amet nulla. Nam in massa. Sed vel tellus. Curabitur sem urna, consequat.</p>
							<ul class="style5">
								<li><a href="#"><img src="images/pics07.jpg" alt=""></a></li>
								<li><a href="#"><img src="images/pics08.jpg" alt=""></a></li>
								<li><a href="#"><img src="images/pics09.jpg" alt=""></a></li>
								<li><a href="#"><img src="images/pics10.jpg" alt=""></a></li>
								<li><a href="#"><img src="images/pics11.jpg" alt=""></a></li>
								<li><a href="#"><img src="images/pics12.jpg" alt=""></a></li>
							</ul>
							<a href="#" class="button">More Collections</a>
						</section>
					</div>
					<div class="3u">
						<section>
							<h2>Support Us</h2>
							<p><strong>Our platform is fully funded by you!</strong></p>
							<p>If you like our website; please consider donating to keep us going!</p>
							<p>Paypall | Bitcoin | Patreon</p>
							<a href="donate.html" class="button">Donate</a>
						</section>
					</div>
				</div>
			</div>
		</div>
	<!-- /Footer -->

	<!-- Copyright -->
		<div id="copyright" class="container">
			Design: <a href="http://templated.co">TEMPLATED</a> Images: <a href="http://unsplash.com">Unsplash</a> (<a href="http://unsplash.com/cc0">CC0</a>)
		</div>


	</body>
</html>
