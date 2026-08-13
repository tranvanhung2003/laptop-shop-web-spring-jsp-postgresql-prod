function setupImagePreview(fileInputId, previewId) {
    const fileInput = $(`#${fileInputId}`);
    const preview = $(`#${previewId}`);

    fileInput.change(function (e) {
        const imgURL = URL.createObjectURL(e.target.files[0]);
        preview.attr("src", imgURL);
        preview.css({ "display": "block" });
    });
}

$(document).ready(() => {
    setupImagePreview("avatarFile", "avatarPreview");
})