<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
</main>
<footer>
	<div class="inner">
		<p>© 2025 렌트카. All rights reserved.</p>
	</div>
</footer>
</div>
</body>
</html>

<script>
	let currentSlide = 0;
	const slides = document.querySelectorAll('.myslider div');
	function showNextSlide() {
		slides[currentSlide].style.opacity = 0;
		currentSlide = (currentSlide + 1) % slides.length;
		slides[currentSlide].style.opacity = 1;
	}
	setInterval(showNextSlide, 3000);
</script>