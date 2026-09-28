function showForm() {
    document.getElementById("containerForm").style.display = "block";
}


function loadContainers() {

    fetch("/api/containers")
        .then(response => response.json())
        .then(data => {

            let table = document.getElementById("containerTable");

            if (!table) {
                return;
            }

            table.innerHTML = "";

            data.forEach(container => {

                let row = `
                    <tr>
                        <td>${container.id}</td>
                        <td>${container.containerNumber}</td>
                        <td>${container.type}</td>
                        <td>${container.status}</td>
                        <td>${container.storageLocation}</td>
                        <td>
                            <button onclick="deleteContainer(${container.id})">
                                Delete
                            </button>
                        </td>
                    </tr>
                `;

                table.innerHTML += row;
            });

        });
}


function loadContainerCount() {

    fetch("/api/containers/count")
        .then(response => response.json())
        .then(count => {

            let countElement =
                document.getElementById("totalContainers");

            if (countElement) {
                countElement.innerText = count;
            }

        });
}


function addContainer() {

    let container = {

        containerNumber:
            document.getElementById("containerNumber").value,

        type:
            document.getElementById("type").value,

        status:
            document.getElementById("status").value,

        storageLocation:
            document.getElementById("storageLocation").value
    };


    fetch("/api/containers", {

        method: "POST",

        headers: {
            "Content-Type": "application/json"
        },

        body: JSON.stringify(container)

    })
    .then(response => response.json())
    .then(data => {

        alert("Container added successfully!");

        document.getElementById("containerNumber").value = "";
        document.getElementById("type").value = "";
        document.getElementById("status").value = "";
        document.getElementById("storageLocation").value = "";

        document.getElementById("containerForm").style.display = "none";

        loadContainers();
        loadContainerCount();

    });
}


function deleteContainer(id) {

    fetch("/api/containers/" + id, {

        method: "DELETE"

    })
    .then(() => {

        alert("Container deleted!");

        loadContainers();
        loadContainerCount();

    });
}


loadContainers();
loadContainerCount();