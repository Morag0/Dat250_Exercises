<script>
    import PollVoter from "./pollVoter.svelte";


let question = "";
let options = [];
let createdPoll = null;

function addOptions() {
    options = [...options, ""];
}

function removeOptions(index) {
    options = options.filter((_, i) => i !== index);
}

async function createPoll() {
    const poll = {
        question,
        publishedAt: new Date().toISOString(),
        validUntil: new Date(new Date().getTime() + 24 * 60 * 60 * 1000).toISOString(),
        options: options.map((option, index) => ({
            caption: option,
            presentationOrder: index + 1,
            votes: 0
        }))
    };

    const response = await fetch('/polls', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(poll)
    });

    if (response.ok) {
        createdPoll = await response.json();
        console.log('Poll created successfully');
    } else {
        console.error('Failed to create poll');
    }
}


</script>


<div>
    <h2>Create a New Poll</h2>
    <input type="text" bind:value={question} placeholder="Enter your question" />
    {#each options as option, index}
        <div>
            <input type="text" bind:value={options[index]} placeholder={`Option ${index + 1}`} />
            <button type="button" on:click={() => removeOptions(index)}>Remove</button>
        </div>
    {/each}
    <button type="button" on:click={addOptions}>Add Option</button>
    <button type="button" on:click={createPoll}>Create Poll</button>
</div>

{#if createdPoll}
    <PollVoter poll={createdPoll} />
{/if}