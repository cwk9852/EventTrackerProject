window.addEventListener('load', function() {

	console.log("loaded");
	getAllOutbreaks();
	document.getOutbreakById.submit.addEventListener('click', getOneOutbreak);
	document.newOutbreak.submit.addEventListener('click', createOutbreak);
	document.getOutbreaks.submit.addEventListener('click', displayOutbreaks);

});
var outbreak = {};
function createOutbreak(e) {
	e.preventDefault();
	var url = `api/outbreaks`
	var xhr = new XMLHttpRequest();
	xhr.open('POST', url, true);
	xhr.setRequestHeader("Content-type", "application/json");

	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4) {
			if (xhr.status < 400) {
				outbreak = JSON.parse(xhr.responseText);
				console.log(outbreak.id);
				displayOutbreak();
				getAllOutbreaks();
			} else {
				document.getElementById('tablebody').textContent = '';
			}
		}
	}

	let outbreakObject = {
		date : document.newOutbreak.date.value,
		summary : document.newOutbreak.summary.value,
		disease : document.newOutbreak.disease.value,
		location : document.newOutbreak.location.value,
		species : document.newOutbreak.species.value,
		cases : document.newOutbreak.cases.value,
		deaths : document.newOutbreak.deaths.value,
		significance : document.newOutbreak.significance.value,
	}
	xhr.send(JSON.stringify(outbreakObject));
	document.newOutbreak.reset();
}

function getAllOutbreaks() {
	var xhr = new XMLHttpRequest();
	xhr.open('GET', 'api/outbreaks');
	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4) {
			if (xhr.readyState < 400) {
				outbreaks = JSON.parse(xhr.responseText);
			} else {
				console.error(xhr.status + ': ' + xhr.responseText);
			}
		}
	}
	xhr.send(null);
}

function displayOutbreaks(e) {
	e.preventDefault();
	document.getElementById('tablebody').textContent = '';

	outbreaks.forEach(function(val, index, array) {
		let outbreakTr = document.createElement('tr');
		let dateTd = document.createElement('td');
		dateTd.textContent = val.date;
		outbreakTr.appendChild(dateTd);
		let summaryTd = document.createElement('td');
		summaryTd.textContent = val.summary;
		outbreakTr.appendChild(summaryTd);
		let diseaseTd = document.createElement('td');
		diseaseTd.textContent = val.disease;
		outbreakTr.appendChild(diseaseTd);
		let locationTd = document.createElement('td');
		locationTd.textContent = val.location;
		outbreakTr.appendChild(locationTd);
		let speciesTd = document.createElement('td');
		speciesTd.textContent = val.species;
		outbreakTr.appendChild(speciesTd);
		let casesTd = document.createElement('td');
		casesTd.textContent = val.cases;
		outbreakTr.appendChild(casesTd);
		let deathsTd = document.createElement('td');
		deathsTd.textContent = val.deaths;
		outbreakTr.appendChild(deathsTd);
		let significaneTd = document.createElement('td');
		significaneTd.textContent = val.significance;
		outbreakTr.appendChild(significaneTd);
		document.getElementById('tablebody').appendChild(outbreakTr);
	});

}

function getOneOutbreak(e) {
	e.preventDefault();
	var oid = document.getOutbreakById.oid.value;
	var xhr = new XMLHttpRequest();
	xhr.open('GET', 'api/outbreaks/' + oid, true);
	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4) {
			if (xhr.readyState < 400) {
				outbreak = JSON.parse(xhr.responseText);
				displayOutbreak();
			} else {
				console.error(xhr.status + ': ' + xhr.responseText);
			}
		}
	}
	xhr.send(null);

}

function displayOutbreak() {
	document.getElementById('tablebody').textContent = '';
	// console.log("inDisplay1");
	let outbreakTr2 = document.createElement('tr');
	let dateTd = document.createElement('td');
	dateTd.textContent = outbreak.date;
	outbreakTr2.appendChild(dateTd);
	let summaryTd = document.createElement('td');
	summaryTd.textContent = outbreak.summary;
	outbreakTr2.appendChild(summaryTd);
	let diseaseTd = document.createElement('td');
	diseaseTd.textContent = outbreak.disease;
	outbreakTr2.appendChild(diseaseTd);
	let locationTd = document.createElement('td');
	locationTd.textContent = outbreak.location;
	outbreakTr2.appendChild(locationTd);
	let speciesTd = document.createElement('td');
	speciesTd.textContent = outbreak.species;
	outbreakTr2.appendChild(speciesTd);
	let casesTd = document.createElement('td');
	casesTd.textContent = outbreak.cases;
	outbreakTr2.appendChild(casesTd);
	let deathsTd = document.createElement('td');
	deathsTd.textContent = outbreak.deaths;
	outbreakTr2.appendChild(deathsTd);
	let significaneTd = document.createElement('td');
	significaneTd.textContent = outbreak.significance;
	outbreakTr2.appendChild(significaneTd);
	document.getElementById('tablebody').appendChild(outbreakTr2);
};