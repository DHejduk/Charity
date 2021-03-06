document.addEventListener("DOMContentLoaded", function () {
    const tmp = document.querySelectorAll("input[type='hidden'][name='_categories']")
    tmp.forEach(function (input){
        input.remove();
    })
    /**
     * Form Select
     */
    class FormSelect {
        constructor($el) {
            this.$el = $el;
            this.options = [...$el.children];
            this.init();
        }

        init() {
            this.createElements();
            this.addEvents();
            this.$el.parentElement.removeChild(this.$el);
        }

        createElements() {
            // Input for value
            this.valueInput = document.createElement("input");
            this.valueInput.type = "text";
            this.valueInput.name = this.$el.name;

            // Dropdown container
            this.dropdown = document.createElement("div");
            this.dropdown.classList.add("dropdown");

            // List container
            this.ul = document.createElement("ul");

            // All list options
            this.options.forEach((el, i) => {
                const li = document.createElement("li");
                li.dataset.value = el.value;
                li.innerText = el.innerText;

                if (i === 0) {
                    // First clickable option
                    this.current = document.createElement("div");
                    this.current.innerText = el.innerText;
                    this.dropdown.appendChild(this.current);
                    this.valueInput.value = el.value;
                    li.classList.add("selected");
                }

                this.ul.appendChild(li);
            });

            this.dropdown.appendChild(this.ul);
            this.dropdown.appendChild(this.valueInput);
            this.$el.parentElement.appendChild(this.dropdown);
        }

        addEvents() {
            this.dropdown.addEventListener("click", e => {
                const target = e.target;
                this.dropdown.classList.toggle("selecting");

                // Save new value only when clicked on li
                if (target.tagName === "LI") {
                    this.valueInput.value = target.dataset.value;
                    this.current.innerText = target.innerText;
                }
            });
        }
    }

    document.querySelectorAll(".form-group--dropdown select").forEach(el => {
        new FormSelect(el);
    });

    /**
     * Hide elements when clicked on document
     */
    document.addEventListener("click", function (e) {
        const target = e.target;
        const tagName = target.tagName;

        if (target.classList.contains("dropdown")) return false;

        if (tagName === "LI" && target.parentElement.parentElement.classList.contains("dropdown")) {
            return false;
        }

        if (tagName === "DIV" && target.parentElement.classList.contains("dropdown")) {
            return false;
        }

        document.querySelectorAll(".form-group--dropdown .dropdown").forEach(el => {
            el.classList.remove("selecting");
        });
    });

    /**
     * Switching between form steps
     */
    class FormSteps {
        constructor(form) {
            this.$form = form;
            this.$next = form.querySelectorAll(".next-step");
            this.$prev = form.querySelectorAll(".prev-step");
            this.$step = form.querySelector(".form--steps-counter span");
            this.currentStep = 1;

            this.$stepInstructions = form.querySelectorAll(".form--steps-instructions p");
            const $stepForms = form.querySelectorAll("form > div");
            this.slides = [...this.$stepInstructions, ...$stepForms];

            this.init();
        }

        /**
         * Init all methods
         */
        init() {
            this.events();
            this.updateForm();
        }

        /**
         * All events that are happening in form
         */
        events() {
            // Next step
            this.$next.forEach(btn => {
                btn.addEventListener("click", e => {
                    e.preventDefault();
                    this.currentStep++;
                    this.updateForm();
                });
            });

            // Previous step
            this.$prev.forEach(btn => {
                btn.addEventListener("click", e => {
                    e.preventDefault();
                    this.currentStep--;
                    this.updateForm();
                });
            });

            // Form submit
            this.$form.querySelector("form").addEventListener("submit", e => this.submit(e));
        }

        /**
         * Update form front-end
         * Show next or previous section etc.
         */
        updateForm() {
            this.$step.innerText = this.currentStep;

            // TODO: Validation



            this.slides.forEach(slide => {
                slide.classList.remove("active");

                if (slide.dataset.step == this.currentStep) {
                    slide.classList.add("active");
                }
            });

            this.$stepInstructions[0].parentElement.parentElement.hidden = this.currentStep >= 5;
            this.$step.parentElement.hidden = this.currentStep >= 5;

            // TODO: get data from inputs and show them in summary

            if (this.currentStep===5){
                const categories = [...document.querySelectorAll("input[name='categories']:checked")];
                // const  quantity= document.querySelector("input[name='bags'][type='number']");
                const organization =[...document.querySelectorAll("input[name='organization']")];
                // const street = document.querySelector("input[name='address'][type='text']");
                const city = document.querySelector("input[name='city']").value;
                // const zipCode = document.querySelector("input[name='postcode']");
                // const phone = document.querySelector("input[name='phone']");
                // const date = document.querySelector("input[name='data'][type='date']");
                // const time = document.querySelector("input[name='time'][type='time']");
                // const info = document.querySelector("input[name='more_info']");

                const quantity = document.getElementById('quantity').value;
                const street = document.getElementById('street').value;
                const zipCode = document.getElementById('zipCode').value;
                const phone = document.getElementById('phone').value;
                const date = document.getElementById('date').value;
                const time = document.getElementById('time').value;
                const info = document.getElementById('info').value;


                console.log(categories)
                console.log(quantity)
                console.log(organization)
                console.log(street)
                console.log(city)
                console.log(zipCode)
                console.log(phone)
                console.log(date)
                console.log(time)
                console.log(info)

                let arrAddress = [...document.querySelectorAll(".summary .form-section--column li")];
                arrAddress[0].innerText=street;
                arrAddress[1].innerText=city;
                arrAddress[2].innerText=zipCode;
                arrAddress[3].innerText=phone;
                arrAddress[4].innerText=date;
                arrAddress[5].innerText=time;
                arrAddress[6].innerText=info;

            }



        }

    }



    const form = document.querySelector(".form--steps");
    if (form !== null) {
        new FormSteps(form);
    }
});
