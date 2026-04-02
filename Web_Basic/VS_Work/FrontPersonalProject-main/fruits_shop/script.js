// DOM 요소
const fruitList = document.getElementById("fruitList");
const veggieList = document.getElementById("veggieList");

const searchBox = document.getElementById("searchBox");
const sortSelect = document.getElementById("sortSelect");
const loadMoreBtn = document.getElementById("loadMoreBtn");

// 카드 렌더링 함수
function renderProducts(data, container) {
	//container는 fruitList or veggieList 전달
	console.log(data);

	container.innerHTML = "";

	/*
아래의 item의 구조
  {
      id: 1,
      name: "수박",
      img: "img/watermelon.jpg",
      content: "당도선별 프리미엄 고당도 하우스수박 5~6kg",
      price: 29000,
    }
  */
	data.forEach((item) => {
		container.innerHTML += `
      <div class="col-md-4">
        <div class="card h-100 shadow-sm">
        <a href="detail.html?id=${item.id}" class="text-decoration-none text-dark">
          <img src="${item.img}" class="card-img-top" alt="${item.name}">
          <div class="card-body text-center">
            <h5 class="card-title">${item.name}</h5>
            <p class="card-text text-primary fw-bold">${item.price.toLocaleString()}원</p>
          </div>
          </a>
        </div>
      </div>`;
	});
}

// 과일 출력
function filterAndSortFruits() {
	//console.log("1")
	//searchBox에 값이 있는지 가져온다.
	let keyword = searchBox.value.trim(); //공백제거
	let filtered = fruits.filter((fruit) => fruit.name.includes(keyword));

	//정렬
	if (sortSelect.value === "low") {
		filtered.sort((a, b) => a.price - b.price);
	} else if (sortSelect.value === "high") {
		filtered.sort((a, b) => b.price - a.price);
	} else if (sortSelect.value === "name") {
		filtered.sort((a, b) => a.name.localeCompare(b.name));
	}

	console.log(filtered.length);
	//화면 출력
	renderProducts(filtered, fruitList);
}

// 채소 출력 (3개씩 증가)
let veggiePage = 0;
function loadVeggies() {
	const start = veggiePage * 3; //1
	const end = start + 3;

	const nextItems = veggies.slice(0, end);
	veggiePage++;
	if (end >= veggies.length) loadMoreBtn.style.display = "none";

	//화면 출력
	renderProducts(nextItems, veggieList);
}

// 이벤트 리스너
searchBox.addEventListener("input", filterAndSortFruits);

sortSelect.addEventListener("change", filterAndSortFruits);

loadMoreBtn.addEventListener("click", loadVeggies);

// 초기 실행
filterAndSortFruits();
loadVeggies();
