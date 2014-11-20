var $overlay = $('<div id="overlay"></div>');
var $image = $('<img>');
var $caption = $('<p></p>');
$overlay.append($image);
$overlay.append($caption);

$('body').append($overlay);

$('#gallery a').click(function(event) {
	event.preventDefault();
	var lienImage = $(this).attr('href');
	var captionText = $(this).children('img').attr('alt');
	$image.attr('src', lienImage);
	$caption.text(captionText);
	$overlay.show();

	console.log(captionText);

});

$overlay.click(function(event) {

	$overlay.hide();

});
//$ajax(url,setting);
$('header').load('header.html');
$.getJSON('../article.json',function(data){
	$.each(data, function(index, article){
		var item='<article>'+
		'<h3>'+ article.title +'</h3>'+
		'<small>'+ article.date +'</small>'+
		'<p>'+ article.content +'</p>'
		+'</article>';
		//console.log(article.content);
		$('.blog-content').append(item);
	});
});








