import React from "react";

interface DetailsProps {
    names: string[];
} 

const Details = (props: DetailsProps) => {
    const { names } = props;
    return (
        <div>
            <h4>Details</h4>
             <ul>

               {names.map((name, index) => (<li key={index}>{name}</li>))}


               </ul>
        </div>
    )
}

export default Details; 